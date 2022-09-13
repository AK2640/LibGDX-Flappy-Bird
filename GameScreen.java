package com.mygdx.game.screens;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Obstacle;
import com.mygdx.game.Player;

public class GameScreen implements Screen {

    private MyGdxGame game;

    private Camera camera;
    private Viewport viewport;
    private SpriteBatch batch;
    private ShapeRenderer shape;
    
    private Random random;
    private Texture background;
    private Player player;
    private List<Obstacle> obstacles;
    private long playerTravelDistance;

    public GameScreen(MyGdxGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        camera = new OrthographicCamera();
        viewport = new ExtendViewport((float) Gdx.graphics.getWidth(), (float) Gdx.graphics.getHeight(), camera);
        batch = new SpriteBatch();
        shape = new ShapeRenderer();
        
        random = new Random();
        background = new Texture(Gdx.files.internal("textures/background.png"));
        player = new Player();
        obstacles = new ArrayList<Obstacle>();

       
    }

    @Override
    public void render(float delta) {
        /** Logic */
        player.tick();
        for(Obstacle obstacle : obstacles){
            obstacle.tick();
        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.E)){
            obstacles.add(new Obstacle(random));
        }
       
        playerTravelDistance++;

        /** Texture Rendering */
        batch.enableBlending();
        batch.begin();
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        player.draw(batch);
        batch.end();

        /** Shape Rendering */
        shape.begin(ShapeType.Filled);
        for(Obstacle obstacle : obstacles){
            obstacle.drawBottomObstacle(shape);
            obstacle.drawTopObstacle(shape);
        }
      
        shape.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        shape.dispose();
        background.dispose();
        player.dispose();

        for(Obstacle obstacle : obstacles){
            obstacle.dispose();
        }
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }
}