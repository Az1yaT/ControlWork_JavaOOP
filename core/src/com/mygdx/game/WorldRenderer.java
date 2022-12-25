package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Heroes.*;

public class WorldRenderer {
    SpriteBatch batch;
    World world;
    BitmapFont font = new BitmapFont();

    public WorldRenderer(SpriteBatch batch, World world) {
        this.world = world;
        this.batch = batch;
    }

    public void render() {
        renderBackground();
        drawHeroes();
    }

    public void renderBackground() {
        batch.begin();
        batch.draw(Assets.background, 0, 0);
        batch.end();
    }

    public void drawWizard() {
        Wizard wizard_1 = world.getWizard_1();
        draw(wizard_1, wizard_1.getWizardTexture(), -1);
    }

    public void drawMonk() {
        Monk monk_1 = world.getMonk_1();
        draw(monk_1, monk_1.getMonkTexture(), 1);
    }

    public void drawPeasant() {
        Peasant peasant_2 = world.getPeasant_2();
        Peasant peasant_1 = world.getPeasant_1();
        draw(peasant_1, peasant_1.getPeasantTexture(), 1);
        draw(peasant_2, peasant_2.getPeasantTexture(), -1);
    }

    public void drawRobber() {
        Robber robber_1 = world.getRobber_1();
        draw(robber_1, robber_1.getRobberTexture(), -1);
    }

    public void drawSniper() {
        Sniper sniper_1 = world.getSniper_1();
        draw(sniper_1, sniper_1.getSniperTexture(), -1);
    }

    private void drawHeroes() {
        batch.begin();
        drawXbowman();
        drawMonk();
        drawSpearman();

        drawSniper();
        drawRobber();
        drawWizard();
        drawPeasant();

        world.getSpearman().getCurrentAnimation().setTime(Gdx.graphics.getDeltaTime());
        world.getMonk_1().getCurrentAnimation().setTime(Gdx.graphics.getDeltaTime());
        world.getPeasant_1().getCurrentAnimation().setTime(Gdx.graphics.getDeltaTime());
        world.getPeasant_2().getCurrentAnimation().setTime(Gdx.graphics.getDeltaTime());
        world.getXbowman_1().getCurrentAnimation().setTime(Gdx.graphics.getDeltaTime());
        world.getWizard_1().getCurrentAnimation().setTime(Gdx.graphics.getDeltaTime());
        world.getRobber_1().getCurrentAnimation().setTime(Gdx.graphics.getDeltaTime());
        world.getSniper_1().getCurrentAnimation().setTime(Gdx.graphics.getDeltaTime());
        batch.end();
    }

    private void draw(BaseHero hero, TextureRegion region, int rotate) {
        batch.draw(region, hero.getPosition().x, hero.getPosition().y,
                100, 0, 200, 200, hero.getDirection(), 1, 0);

    }

    private void drawXbowman() {
        Xbowman xbowman_1 = world.getXbowman_1();
        draw(xbowman_1, xbowman_1.getXbowmanTexture(), 1);
    }

    private void drawSpearman() {
        Spearman spearman = world.getSpearman();
        draw(spearman, spearman.getSpearmanTexture(), 1);
    }
}