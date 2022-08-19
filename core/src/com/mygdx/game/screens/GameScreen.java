package com.mygdx.game.screens;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Player;

public class GameScreen implements Screen {

    private MyGdxGame game;

    private Camera camera;
    private Viewport viewport;
    private SpriteBatch batch;

    private Texture background;
    private Player player;
    private long playerTravelDistance;

    private Random random;
    private Texture obstacleTexture;
    private int obstacleX;
    private int obstacleHeight;
    private int obstacleWidth; 
    
    
    public GameScreen(MyGdxGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        camera = new OrthographicCamera();
        viewport = new ExtendViewport((float) Gdx.graphics.getWidth(), (float) Gdx.graphics.getHeight(), camera);
        batch = new SpriteBatch();

        background = new Texture(Gdx.files.internal("textures/background.png"));
        player = new Player();

        random = new Random();
        obstacleTexture = new Texture(Gdx.files.internal("textures/pipe.png"));


        obstacleX = Gdx.graphics.getWidth() - 50;
        obstacleHeight = random.nextInt(250) + 400;
        obstacleWidth = random.nextInt(100) + 50;
    }

    @Override
    public void render(float delta) {
        /** LOgic */
        player.tick();
        playerTravelDistance++;
        obstacleX--;
        // if(playerTravelDistance % 120 == 0){
        //     //spawn
        // }

        /** Rendering */
        batch.enableBlending();
        batch.begin();

        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        player.draw(batch);
        batch.draw(obstacleTexture, obstacleX, 50, obstacleWidth, obstacleHeight );
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        background.dispose();
        player.dispose();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    @Override
    public void pause() {
        // TODO Auto-generated method stub

    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub

    }

    @Override
    public void hide() {
        // TODO Auto-generated method stub

    }
}