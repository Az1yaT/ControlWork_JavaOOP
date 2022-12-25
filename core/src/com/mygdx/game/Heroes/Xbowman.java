package com.mygdx.game.Heroes;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Assets;
import com.mygdx.game.GameAnimation;

import java.util.ArrayList;

public class Xbowman extends Shooter {
    GameAnimation currentAnimation;

    public Xbowman(ArrayList<BaseHero> group, int x, int y, int direction) {
        super(6, 3, new int[] { 2, 3 }, 100, 4, States.ALIVE, 16);
        super.group = group;
        super.position = new Position(x, y);
        super.texture = new Texture("Xbowman.png");
        super.direction = direction;
    }

    public TextureRegion getXbowmanTexture() {
        if (currentAnimation == null || currentAnimation.isFinished()) {
            switch (getState()) {
                case ALIVE:
                    currentAnimation = Assets.xbowmanStandingAnimation;
                    break;
                case DEAD:
                    currentAnimation = Assets.xbowmanDyingAnimation;
                    break;
                case ATTACK:
                    currentAnimation = Assets.xbowmanAttackingAnimation;
                    break;
                case HURT:
                    currentAnimation = Assets.xbowmanHurtAnimation;

            }
        }
        return currentAnimation.getFrame();
    }

    public GameAnimation getCurrentAnimation() {
        return currentAnimation;
    }

    @Override
    public String getInfo() {
        return super.getInfo();
    }
}
