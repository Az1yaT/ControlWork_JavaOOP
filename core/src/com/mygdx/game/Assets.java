package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Assets {
        public static BitmapFont font;
        public static Texture menu;
        public static Texture background;
        public static Texture gameOverBackground;

        public static Sound xbowSound;
        private static TextureAtlas spearmanAtlas, monkAtlas, peasantAtlas, xbowmanAtlas, wizardAtlas, robberAtlas,sniperAtlas;
        public static GameAnimation spearmanStandingAnimation, spearmanDyingAnimation, spearmanAttackingAnimation,spearmanWalkingAnimation, spearmanHurtAnimation;
        public static GameAnimation monkStandingAnimation, monkDyingAnimation, monkAttackingAnimation,monkHurtAnimation;
        public static GameAnimation peasantStandingAnimation, peasantDyingAnimation, peasantHurtAnimation;
        public static GameAnimation xbowmanStandingAnimation, xbowmanDyingAnimation, xbowmanAttackingAnimation,xbowmanHurtAnimation;
        public static GameAnimation wizardStandingAnimation, wizardDyingAnimation, wizardAttackingAnimation,wizardHurtAnimation;
        public static GameAnimation robberStandingAnimation, robberDyingAnimation, robberAttackingAnimation,robberWalkingAnimation, robberHurtAnimation;
        public static GameAnimation sniperStandingAnimation, sniperDyingAnimation, sniperAttackingAnimation,sniperHurtAnimation;

        public static Texture loadTexture(String file) {
                return new Texture(Gdx.files.internal(file));
        }

        public static void load() {
                spearmanAtlas = new TextureAtlas("lancer.atlas");
                spearmanStandingAnimation = new GameAnimation(spearmanAtlas, "Elf_02__IDLE", 9,
                                Animation.PlayMode.LOOP);
                spearmanDyingAnimation = new GameAnimation(spearmanAtlas, "Elf_02__DIE", 9, Animation.PlayMode.NORMAL);
                spearmanAttackingAnimation = new GameAnimation(spearmanAtlas, "Elf_02__ATTACK", 9,
                                Animation.PlayMode.NORMAL);
                spearmanWalkingAnimation = new GameAnimation(spearmanAtlas, "Elf_02__WALK", 20,
                                Animation.PlayMode.LOOP);
                spearmanHurtAnimation = new GameAnimation(spearmanAtlas, "Elf_02__HURT", 9, Animation.PlayMode.NORMAL);

                monkAtlas = new TextureAtlas("monk.atlas");
                monkStandingAnimation = new GameAnimation(monkAtlas, "Fairy_03__IDLE", 9, Animation.PlayMode.LOOP);
                monkDyingAnimation = new GameAnimation(monkAtlas, "Fairy_03__DIE", 9, Animation.PlayMode.NORMAL);
                monkAttackingAnimation = new GameAnimation(monkAtlas, "Fairy_03__ATTACK", 9, Animation.PlayMode.NORMAL);
                monkHurtAnimation = new GameAnimation(monkAtlas, "Fairy_03__HURT", 9, Animation.PlayMode.NORMAL);

                peasantAtlas = new TextureAtlas("Peasant.atlas");
                peasantStandingAnimation = new GameAnimation(peasantAtlas, "0_Fallen_Angels_Idle Blinking", 9,
                                Animation.PlayMode.LOOP);
                peasantDyingAnimation = new GameAnimation(peasantAtlas, "0_Fallen_Angels_Dying", 9,
                                Animation.PlayMode.NORMAL);
                peasantHurtAnimation = new GameAnimation(peasantAtlas, "0_Fallen_Angels_Hurt", 9,
                                Animation.PlayMode.NORMAL);

                xbowmanAtlas = new TextureAtlas("crossbow.atlas");
                xbowmanStandingAnimation = new GameAnimation(xbowmanAtlas, "Warrior_03__IDLE", 9,
                                Animation.PlayMode.LOOP);
                xbowmanAttackingAnimation = new GameAnimation(xbowmanAtlas, "Warrior_03__ATTACK", 9,
                                Animation.PlayMode.NORMAL);
                xbowmanDyingAnimation = new GameAnimation(xbowmanAtlas, "Warrior_03__DIE", 9,
                                Animation.PlayMode.NORMAL);
                xbowmanHurtAnimation = new GameAnimation(xbowmanAtlas, "Warrior_03__HURT", 9,
                                Animation.PlayMode.NORMAL);

                wizardAtlas = new TextureAtlas("wizard.atlas");
                wizardStandingAnimation = new GameAnimation(wizardAtlas, "Elf_03__IDLE", 9, Animation.PlayMode.LOOP);
                wizardAttackingAnimation = new GameAnimation(wizardAtlas, "Elf_03__ATTACK", 9,
                                Animation.PlayMode.NORMAL);
                wizardDyingAnimation = new GameAnimation(wizardAtlas, "Elf_03__DIE", 9, Animation.PlayMode.NORMAL);
                wizardHurtAnimation = new GameAnimation(wizardAtlas, "Elf_03__HURT", 9, Animation.PlayMode.NORMAL);

                robberAtlas = new TextureAtlas("robber.atlas");
                robberStandingAnimation = new GameAnimation(robberAtlas, "Troll_03_1_IDLE", 9, Animation.PlayMode.LOOP);
                robberAttackingAnimation = new GameAnimation(robberAtlas, "Troll_03_1_ATTACK", 9,
                                Animation.PlayMode.NORMAL);
                robberDyingAnimation = new GameAnimation(robberAtlas, "Troll_03_1_DIE", 9, Animation.PlayMode.NORMAL);
                robberWalkingAnimation = new GameAnimation(robberAtlas, "Troll_03_1_RUN", 20, Animation.PlayMode.LOOP);
                robberHurtAnimation = new GameAnimation(robberAtlas, "Troll_03_1_HURT", 9, Animation.PlayMode.NORMAL);

                sniperAtlas = new TextureAtlas("sniper.atlas");
                sniperStandingAnimation = new GameAnimation(sniperAtlas, "Elf_01__IDLE", 9, Animation.PlayMode.LOOP);
                sniperAttackingAnimation = new GameAnimation(sniperAtlas, "Elf_01__ATTACK", 9,
                                Animation.PlayMode.NORMAL);
                sniperDyingAnimation = new GameAnimation(sniperAtlas, "Elf_01__DIE", 9, Animation.PlayMode.NORMAL);
                sniperHurtAnimation = new GameAnimation(sniperAtlas, "Elf_01__HURT", 9, Animation.PlayMode.NORMAL);

                menu = new Texture("helloScreen.jpg");
                background = loadTexture("background.jpg");
                gameOverBackground = new Texture("endScreen.jpg");
                font = new BitmapFont();
        }
}
