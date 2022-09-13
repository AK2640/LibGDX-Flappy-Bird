package com.mygdx.game;
import java.util.Random;
import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Obstacle {

    public static final int OBSTACLE_START_X_OFFSET = 50;
    public static final int OBSTACLE_BOTTOM_MAXIMUM_HEIGHT = 450;
    
    private int gap;
    private int obsOneHeight;
    private int obsTwoHeight;
    private int obstacleWidth;
    private int obstacleX;

    // <TODO:>
    //Change magic numbers to constant - STILL GOING
    //Make minimum gaps between pipes - STILL GOING
    //Fix placement of pipes - STILL GOING
    //change naming from "one" and "two" to "top" and "bottom" - DONE
    //push code to github AND stay on "main" branch. get rid of "master" branch.
    public Obstacle(Random random) {
        gap = 200;
        obsOneHeight = random.nextInt(450) + 50;
        obsTwoHeight =  Gdx.graphics.getHeight() - (obsOneHeight + gap);
        obstacleWidth = 50;
        obstacleX = Gdx.graphics.getWidth() + OBSTACLE_START_X_OFFSET;
    }

    public void drawTopObstacle(ShapeRenderer renderer){
        renderer.rect(obstacleX, 50, obstacleWidth, obsOneHeight);
        renderer.setColor(Color.GREEN);
    }

    public void drawBottomObstacle(ShapeRenderer renderer){
        renderer.rect(obstacleX, 500, obstacleWidth, obsTwoHeight);
        renderer.setColor(Color.GREEN);
    }

    public void tick() {
        obstacleX--;

    }    

    public void dispose() {
        //TODO: Dispose texture
        //name.dispose();
    }
}
