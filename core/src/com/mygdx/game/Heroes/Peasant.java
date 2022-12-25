package com.mygdx.game.Heroes;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Assets;
import com.mygdx.game.GameAnimation;

import java.util.ArrayList;

public class Peasant extends Warrior {
    boolean delivery;
    GameAnimation currentAnimation;

    public Peasant(ArrayList<BaseHero> group, int x, int y, int direction) {
        super(1, 1, new int[] { 1, 1 }, 10, 3, States.ALIVE);
        super.group = group;
        delivery = true;
        super.position = new Position(x, y);
        super.texture = new Texture("Peasant.png");
        super.direction = direction;
    }

    public TextureRegion getPeasantTexture() {
        if (currentAnimation == null || currentAnimation.isFinished()) {
            switch (getState()) {
                case ALIVE:
                    currentAnimation = Assets.peasantStandingAnimation;
                    break;
                case DEAD:
                    currentAnimation = Assets.peasantDyingAnimation;
                    break;
                case HURT:
                    currentAnimation = Assets.peasantHurtAnimation;
            }
        }
        return currentAnimation.getFrame();
    }

    public GameAnimation getCurrentAnimation() {
        return currentAnimation;
    }

    @Override
    public void step(ArrayList<BaseHero> group) {
        if (getState().equals(States.USED)) {
            setState(States.ALIVE);
        }
    }

    @Override
    public String getInfo() {
        return super.getInfo();
    }
}
