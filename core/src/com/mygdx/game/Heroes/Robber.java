package com.mygdx.game.Heroes;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Assets;
import com.mygdx.game.GameAnimation;

import java.util.ArrayList;

public class Robber extends Warrior {
    GameAnimation currentAnimation;
    boolean delivery;

    public Robber(ArrayList<BaseHero> group, int x, int y, int direction) {
        super(8, 3, new int[] { 2, 4 }, 100, 6, States.ALIVE);
        super.group = group;
        delivery = false;
        super.position = new Position(x, y);
        super.texture = new Texture("Wizard.png");
        super.direction = direction;
    }

    public TextureRegion getRobberTexture() {
        if (currentAnimation == null || currentAnimation.isFinished()) {
            switch (getState()) {
                case ALIVE:
                    currentAnimation = Assets.robberStandingAnimation;
                    break;
                case DEAD:
                    currentAnimation = Assets.robberDyingAnimation;
                    break;
                case ATTACK:
                    currentAnimation = Assets.robberAttackingAnimation;
                    break;
                case WALK:
                    currentAnimation = Assets.robberWalkingAnimation;
                    // case HURT:
                    // currentAnimation = Assets.robberHurtAnimation;

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
