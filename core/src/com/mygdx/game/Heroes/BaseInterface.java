package com.mygdx.game.Heroes;

import java.util.ArrayList;

public interface BaseInterface {
    void step(ArrayList<BaseHero> group);

    String getInfo();
}
