package com.platformer.game;

import com.platformer.gamestates.GameStateManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel
        implements Runnable, KeyListener {


    //dimensions
    public static final int WIDTH = 640;
    public static final int HEIGHT = 360;
    public static final int SCALE = 2;

    //game thread
    private Thread thread;
    private boolean running;
    private int FPS = 60;
    private long targetTime = 1000 / FPS;

    //image
    private BufferedImage image;
    private Graphics2D g;

    //game state manager
    private GameStateManager game;

    public GamePanel(){
        setPreferredSize(new Dimension(WIDTH * SCALE,
                HEIGHT * SCALE));
        setFocusable(true);
        requestFocus();
    }

    public void addNotify(){
        super.addNotify();
        if(thread == null){
            thread = new Thread(this);
            addKeyListener(this);
            thread.start();
        }
    }

    private void init(){
        image = new BufferedImage(WIDTH, HEIGHT,
                BufferedImage.TYPE_INT_RGB);
        g = (Graphics2D) image.getGraphics();
        running = true;
        game = new GameStateManager();
    }

    @Override
    public void run() {

        init();

        long start;
        long elapsed;
        long wait;


        while(running){
            start = System.nanoTime();
            update();
            draw();
            drawToScreen();
            elapsed = System.nanoTime() - start;
            wait = targetTime - elapsed / 1000000;
            try{
                if(wait < 0){
                    wait = 5;
                }
                Thread.sleep(wait);
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
    }


    private void update(){
        game.update();
    }
    private void draw(){
        game.draw(g);
    }
    private void drawToScreen(){
        Graphics g2 = getGraphics();
        g2.drawImage(image, 0, 0, WIDTH*SCALE, HEIGHT*SCALE, null);
        g2.dispose();
    }
    public void keyTyped(KeyEvent key){

    }
    public void keyPressed(KeyEvent key){
        game.keyPressed(key.getKeyCode());
    }
    public void keyReleased(KeyEvent key){
        game.keyReleased(key.getKeyCode());
    }

}
