package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Heroes.MenuScreen;

public class SuperHeroes extends Game {
	public SpriteBatch batch;

	@Override
	public void create() {
		batch = new SpriteBatch();
		Assets.load();
		// setScreen(new GameScreen(this));
		setScreen(new MenuScreen(this));
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void dispose() {
		batch.dispose();
	}
}
