package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.screens.*;

public class MyGdxGame extends Game {

	@Override
	public void create() {
		super.setScreen( new GameScreen(this) );
	}

	@Override
	public void render() {
		ScreenUtils.clear(1, 0, 0, 1);
		super.render();
	}
	
	@Override
	public void dispose() {
		super.dispose();
	}
}
