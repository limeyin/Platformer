package com.platformer.gamestates;

import java.awt.*;

public abstract class GameState {

    protected GameStateManager game;

    public abstract void init();
    public abstract void update();
    public abstract void keyPressed(int k);
    public abstract void keyReleased(int k);
    public abstract void draw(Graphics2D g);

}
