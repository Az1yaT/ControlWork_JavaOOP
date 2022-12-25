package com.mygdx.game.Heroes;

import com.mygdx.game.Assets;

import java.util.ArrayList;

public class Healer extends BaseHero {
    boolean magic;

    public Healer(int attack, int protection, int[] damage, double health, int speed, States state) {
        super(attack, protection, damage, health, speed, state);
        this.magic = true;
    }

    @Override
    public String getInfo() {
        return super.getInfo();
    }

    @Override
    public void step(ArrayList<BaseHero> enemies) {
        if (getState() == States.DEAD) {
            return;
        }
        setState(States.ATTACK);

        int index = findWeakest();

        BaseHero comrade = getGroup().get(index);

        if (comrade.getHealth() / comrade.getMaxHealth() < 0.50) {
            comrade.setHealth(comrade.getHealth() - getDamage()[0]);
        } else {
            if (comrade.getHealth() / comrade.getMaxHealth() > 0.75) {
                attack(findAim(enemies), enemies);
            } else
                revive();
        }
    }

    private void attack(int aim, ArrayList<BaseHero> enemies) {
        if (aim != -1) {
            enemies.get(aim).setHealth(enemies.get(aim).getHealth() + getDamage()[0]);
        }
    }

    private void revive() {
        for (BaseHero comrade : getGroup()) {
            if (comrade.getState() == States.DEAD)
                comrade.setHealth(1);
        }
    }

    private int findAim(ArrayList<BaseHero> enemies) {
        int aim = -1;
        for (int i = 0; i < enemies.size(); i++) {
            if (enemies.get(i).getClass().toString().contains("Shooter") && enemies.get(i).getState() != States.DEAD) {
                aim = i;
            }
        }
        return aim;
    }

    private int findWeakest() {
        double minHp = Double.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < getGroup().size(); i++) {
            if (getGroup().get(i).getHealth() < minHp && getGroup().get(i).getState() != States.DEAD) {
                minHp = getGroup().get(i).getHealth();
                index = i;
            }
        }
        return index;
    }
}