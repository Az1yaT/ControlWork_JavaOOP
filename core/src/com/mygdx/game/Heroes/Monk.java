package com.mygdx.game.Heroes;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Assets;
import com.mygdx.game.GameAnimation;

import java.util.ArrayList;

public class Monk extends Healer {
    GameAnimation currentAnimation;

    public Monk(ArrayList<BaseHero> group, int x, int y, int direction) {
        super(12, 7, new int[] { -4, -4 }, 300, 5, States.ALIVE);
        super.group = group;
        super.position = new Position(x, y);
        super.texture = new Texture("Wizard.png");
        super.direction = direction;
    }

    public TextureRegion getMonkTexture() {
        if (currentAnimation == null || currentAnimation.isFinished()) {
            switch (getState()) {
                case ALIVE:
                    currentAnimation = Assets.monkStandingAnimation;
                    break;
                case DEAD:
                    currentAnimation = Assets.monkDyingAnimation;
                    break;
                case ATTACK:
                    currentAnimation = Assets.monkAttackingAnimation;
                    break;
                case HURT:
                    currentAnimation = Assets.monkHurtAnimation;

            }
        }
        return currentAnimation.getFrame();
    }

    public GameAnimation getCurrentAnimation() {
        return currentAnimation;
    }
}