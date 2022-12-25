package com.mygdx.game.Heroes;

import java.util.ArrayList;

public class Shooter extends BaseHero {
    int shoot;

    public Shooter(int attack, int protection, int[] damage, double health, int speed, States state, int shoot) {
        super(attack, protection, damage, health, speed, state);
        this.shoot = shoot;
    }

    @Override
    public void step(ArrayList<BaseHero> group) {
        if (getState() == States.DEAD)
            return;
        for (int i = 0; i < getGroup().size(); i++) {
            if (getGroup().get(i).getClass().getSimpleName().equals("Peasant") &&
                    getGroup().get(i).getState().equals(States.ALIVE)) {
                shoot++;
                getGroup().get(i).setState(States.USED);
            }
        }

        if (shoot <= 0) {
            return;
        }

        shoot--;
        BaseHero aim = findAim(group);
        getAttack(aim);
    }

    private BaseHero findAim(ArrayList<BaseHero> group) {
        float minDistance = Float.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < group.size(); i++) {
            if (group.get(i).getState() == States.DEAD)
                continue;
            float distance = getPosition().getDist(group.get(i).getPosition());
            if (minDistance > distance) {
                minDistance = distance;
                index = i;
            }
        }
        return group.get(index);
    }
}
