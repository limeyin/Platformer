package com.platformer.game;

import javax.swing.*;

public class Game {

    public static void main(String[] args){
        JFrame window = new JFrame("Platformer");
        window.setVisible(true);
        window.setContentPane(new GamePanel());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);
        window.setSize(GamePanel.WIDTH*GamePanel.SCALE, GamePanel.HEIGHT*GamePanel.SCALE);
    }
}
