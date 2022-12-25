package com.mygdx.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.mygdx.game.SuperHeroes;

public class DesktopLauncher {
	public static void main(String[] args) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("SuperHeroes");
		config.setWindowedMode(1000, 720);
		config.setResizable(false);
		new Lwjgl3Application(new SuperHeroes(), config);
	}
}
