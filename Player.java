package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Player {

    private float y;
    private float width;
    private float height;
    private float gravity;
    // private int increment;

    private Texture player;

    public Player() {
        this.y = Gdx.graphics.getHeight() / 2;
        this.width = 100;
        this.height = 100;
        this.gravity = -5f;
        this.player = new Texture(Gdx.files.internal("textures/player.png")); 
    }

    public void tick() {
        this.y += this.gravity;
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
            y += 200;

            
            //TODO: Change to proper acceleration value
         
        //  if(increment <= 50){
        //   y += increment;
        //   increment++;
        // } 
        }
    }

    public void draw(SpriteBatch batch) {
        batch.draw(player, 50, y, this.width, this.height);
    }

    public void dispose() {
        player.dispose();    
    }
    
}