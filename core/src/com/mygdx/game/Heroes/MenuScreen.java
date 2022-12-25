package com.mygdx.game.Heroes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.mygdx.game.Assets;
import com.mygdx.game.GameScreen;
import com.mygdx.game.SuperHeroes;

public class MenuScreen extends ScreenAdapter {
    SuperHeroes game;

    public MenuScreen(SuperHeroes game) {
        this.game = game;
    }

    @Override
    public void render(float delta) {
        update();
        draw();
    }

    public void update() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
            game.setScreen(new GameScreen(game));
        }
    }

    public void draw() {
        game.batch.begin();
        game.batch.draw(Assets.menu, 0, 0, 1000, 720);
        game.batch.end();
    }

}
