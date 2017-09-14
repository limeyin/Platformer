package com.platformer.gamestates;

import com.platformer.TileMap.Background;
import com.platformer.game.GamePanel;

import java.awt.*;
import java.awt.event.KeyEvent;

public class MenuState extends GameState{

    private String title = "Platformer";
    private Background bg;

    private int currentChoice = 0;
    private String[] options = {
            "New Game", "Load Game", "Levels", "Settings", "Exit "
    };

    private Color titleColor;
    private  Font titleFont;
    private Font font;

    public MenuState(GameStateManager game){
        this.game = game;
        try{
            bg = new Background("/resources/Background/menubg.png", 1);
            bg.setVector(-.1, 0);
            titleColor = new Color(0, 0, 128);
            titleFont = new Font("Century Gothic", Font.PLAIN, 28);
            font = new Font ("Times New Roman", font.PLAIN, 12);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void init(){}
    public void update(){
        bg.update();
    }
    public void draw(Graphics2D g){
        //draw background
        bg.draw(g);
        //draw title
        g.setColor(titleColor);
        g.setFont(titleFont);
        g.drawString(title, GamePanel.WIDTH/2 - g.getFontMetrics().stringWidth(title)/2, GamePanel.HEIGHT/3);
        //draw menu options
        g.setFont(font);
        for(int i = 0; i < options.length; i++){
            if(i == currentChoice){
                g.setColor(Color.GREEN);
            }
            else{
                g.setColor(Color.BLACK);
            }
            g.drawString(options[i], GamePanel.WIDTH/2 - g.getFontMetrics().stringWidth(options[i])/2, GamePanel.HEIGHT/2 + (i *15));
        }
    }

    private void select(){
        if(currentChoice == 0){

        }
        else if(currentChoice == 1){
            //help
        }
        else if(currentChoice == 2){
            System.exit(0);
        }

    }

    public void keyPressed(int k){
        if(k == KeyEvent.VK_ENTER){
            select();
        }
        if(k == KeyEvent.VK_UP){
            currentChoice--;
            if (currentChoice == -1){
                currentChoice = options.length - 1;
            }
        }
        if(k == KeyEvent.VK_DOWN){
            currentChoice++;
            if (currentChoice == options.length){
                currentChoice = 0;
            }
        }
    }
    public void keyReleased(int k){

    }

}
