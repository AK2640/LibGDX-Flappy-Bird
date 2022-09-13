package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MyGdxGame;

public class MainMenuScreen implements Screen {

    private MyGdxGame game;
    
    private Camera camera;
    private Viewport viewport;
    private SpriteBatch batch;
    private Texture background;
    private Music mainMenuMusic;
    private Sound soundEffect;
    
 
    //Add music objec   t that takes audio file and starts playing the file when the game loads into the main menu screen and it loops
    //Create a sound object that plays when the user presses any key

   

    public MainMenuScreen(MyGdxGame game) {
        this.game = game;
    }

    public void userPressSound(){
        soundEffect.play();
    }
    
    @Override
    public void show() {
        camera = new OrthographicCamera((float) Gdx.graphics.getWidth(), (float) Gdx.graphics.getHeight());
        viewport = new ExtendViewport((float) Gdx.graphics.getWidth(), (float) Gdx.graphics.getHeight(), camera);
        batch = new SpriteBatch();

        soundEffect = Gdx.audio.newSound(Gdx.files.internal("assets/sounds/mainMenuScreen.mp3"));
        background = new Texture(Gdx.files.internal("textures/background.png"));  
        mainMenuMusic = Gdx.audio.newMusic(Gdx.files.internal("assets/sounds/mainMenuScreen.mp3")); 

        mainMenuMusic.play();
    }

    @Override
    public void render(float delta) {
        //batch.setProjectionMatrix(camera.combined);

        //<MY CODE FOR SOUND EFFECT>
        if(Gdx.input.isKeyJustPressed(Input.Keys.ANY_KEY)){
            userPressSound();
        }
        batch.enableBlending();
        batch.begin();
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.end();  
    }

    @Override
    public void dispose() {
        batch.dispose();
        background.dispose();
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