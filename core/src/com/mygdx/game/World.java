package com.mygdx.game;

import com.mygdx.game.Heroes.*;
import java.util.ArrayList;
import java.util.Collections;

public class World {
    public static boolean gameOver;
    public static boolean game;
    public ArrayList<BaseHero> whiteSide;
    public ArrayList<BaseHero> darkSide;
    private Spearman spearman_1, spearman_2;
    private Monk monk_1;
    private Peasant peasant_1, peasant_2;
    private Xbowman xbowman_1;
    private Wizard wizard_1;
    private Robber robber_1;
    private Sniper sniper_1;

    public World() {
        this.whiteSide = new ArrayList<>();
        this.darkSide = new ArrayList<>();
        generateScene();
    }

    public Xbowman getXbowman_1() {
        return xbowman_1;
    }

    public Wizard getWizard_1() {
        return wizard_1;
    }

    public Peasant getPeasant_1() {
        return peasant_1;
    }

    public Peasant getPeasant_2() {
        return peasant_2;
    }

    public Monk getMonk_1() {
        return monk_1;
    }

    public Spearman getSpearman() {
        return spearman_1;
    }

    public Robber getRobber_1() {
        return robber_1;
    }

    public Sniper getSniper_1() {
        return sniper_1;
    }

    public void update() {
        for (BaseHero hero : whiteSide) {
            if (hero instanceof Warrior) {
                hero.updatePosition();
            }
        }
        for (BaseHero hero : darkSide) {
            if (hero instanceof Warrior) {
                hero.updatePosition();
            }
        }
        checkGameOver();
    }

    public void setPriority() {
        for (int i = 0; i < whiteSide.size(); i++) {
            String clazz = whiteSide.get(i).getClass().toString();
            if (clazz.contains("Xbowman")) {
                whiteSide.get(i).step(darkSide);
            }
            clazz = darkSide.get(i).getClass().toString();
            if (clazz.contains("Sniper")) {
                darkSide.get(i).step(whiteSide);
            }
        }

        for (int i = 0; i < whiteSide.size(); i++) {
            String clazz = whiteSide.get(i).getClass().toString();
            if (clazz.contains("Spearman")) {
                whiteSide.get(i).step(darkSide);
            }
            clazz = darkSide.get(i).getClass().toString();
            if (clazz.contains("Robber")) {
                darkSide.get(i).step(whiteSide);
            }
        }
        for (int i = 0; i < whiteSide.size(); i++) {
            String clazz = whiteSide.get(i).getClass().toString();
            if (clazz.contains("Monk")) {
                whiteSide.get(i).step(darkSide);
            }
            clazz = darkSide.get(i).getClass().toString();
            if (clazz.contains("Wizard")) {
                darkSide.get(i).step(whiteSide);
            }
        }
        for (int i = 0; i < whiteSide.size(); i++) {
            String clazz = whiteSide.get(i).getClass().toString();
            if (clazz.contains("Peasant")) {
                whiteSide.get(i).step(darkSide);
            }
            if (clazz.contains("Peasant")) {
                darkSide.get(i).step(whiteSide);
            }
        }
    }

    private void checkGameOver() {
        int count = 0;
        int count2 = 0;
        for (int i = 0; i < whiteSide.size(); i++) {
            if (whiteSide.get(i).getState() == States.DEAD) {
                count++;
            }
        }
        for (int i = 0; i < darkSide.size(); i++) {
            if (darkSide.get(i).getState() == States.DEAD) {
                count2++;
            }
        }
        if (count == whiteSide.size() || count2 == darkSide.size()) {
            gameOver = true;
        }
    }

    private void generateScene() {
        int n = 20;
        int width = 1000;
        spearman_1 = new Spearman(whiteSide, 0, 50 + n, 1);
        monk_1 = new Monk(whiteSide, 0, 150 + n, 1);
        peasant_1 = new Peasant(whiteSide, 0, 250 + n, 1);
        xbowman_1 = new Xbowman(whiteSide, 0, 350 + n, 1);

        Collections.addAll(whiteSide, spearman_1, monk_1, peasant_1, xbowman_1);

        peasant_2 = new Peasant(darkSide, width - n * 10, 50 + n, -1);
        wizard_1 = new Wizard(darkSide, width - n * 10, 150 + n, -1);
        robber_1 = new Robber(darkSide, width - n * 10, 250 + n, -1);
        sniper_1 = new Sniper(darkSide, width - n * 10, 350 + n, -1);
        Collections.addAll(darkSide, peasant_2, wizard_1, robber_1, sniper_1);
    }
}