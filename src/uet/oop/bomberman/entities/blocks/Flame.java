package uet.oop.bomberman.entities.blocks;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.dynamic.DynamicEntities;
import uet.oop.bomberman.graphics.Sprite;

import java.awt.*;

import static uet.oop.bomberman.BombermanGame.position;
import static uet.oop.bomberman.entities.blocks.Bomb.*;
import static uet.oop.bomberman.entities.blocks.Bomb.decayTimer;

public class Flame extends Entity {
    public static int flameLength = 1;

    @Override
    public void update() {
    }

    public static boolean canFireDown(int x, int y) {
        return position[x][y + 1] != 1;
    }

    public static boolean canFireUp(int x, int y) {
        return position[x][y - 1] != 1;
    }

    public static boolean canFireLeft(int x, int y) {
        return position[x - 1][y] != 1;
    }

    public static boolean canFireRight(int x, int y) {
        return position[x + 1][y] != 1;
    }

    public Flame(int x, int y, Image _flame) {
        super(x, y, _flame);
    }

    public static void fireFlame(int x, int y) {
        Flame flamecenter = new Flame(x, y, Sprite.bomb_exploded.getFxImage());
        BombermanGame.flame.add(flamecenter);
        flamecenter.setImg(Sprite.movingSprite(Sprite.bomb_exploded, Sprite.bomb_exploded1,
                Sprite.bomb_exploded2, countToExploded, decayTimer).getFxImage());
        for (int i = 0; i < flameLength; i++) {
            if (canFireUp(x, y - i)) {
                if (i == flameLength - 1) {
                    Flame flameup = new Flame(x, y - (i + 1),
                            Sprite.explosion_vertical_top_last.getFxImage());
                    BombermanGame.flame.add(flameup);
                    flameup.setImg(Sprite.movingSprite(Sprite.explosion_vertical_top_last,
                            Sprite.explosion_vertical_top_last1, Sprite.explosion_vertical_top_last2,
                            countToExploded, decayTimer).getFxImage());
                } else {
                    Flame flameup = new Flame(x, y - (i + 1),
                            Sprite.explosion_vertical.getFxImage());
                    BombermanGame.flame.add(flameup);
                    flameup.setImg(Sprite.movingSprite(Sprite.explosion_vertical,
                            Sprite.explosion_vertical1, Sprite.explosion_vertical2,
                            countToExploded, decayTimer).getFxImage());
                }
            } else break;
        }
        for (int i = 0; i < flameLength; i++) {
            if (canFireDown(x, y + i)) {
                if (i == flameLength - 1) {
                    Flame flamedown = new Flame(x, y + (i + 1),
                            Sprite.explosion_vertical_down_last.getFxImage());
                    BombermanGame.flame.add(flamedown);
                    flamedown.setImg(Sprite.movingSprite(Sprite.explosion_vertical_down_last,
                            Sprite.explosion_vertical_down_last1, Sprite.explosion_vertical_down_last2,
                            countToExploded, decayTimer).getFxImage());
                } else {
                    Flame flamedown = new Flame(x, y + (i + 1),
                            Sprite.explosion_vertical.getFxImage());
                    BombermanGame.flame.add(flamedown);
                    flamedown.setImg(Sprite.movingSprite(Sprite.explosion_vertical,
                            Sprite.explosion_vertical1, Sprite.explosion_vertical2,
                            countToExploded, decayTimer).getFxImage());
                }
            } else break;
        }
        for (int i = 0; i < flameLength; i++) {
            if (canFireLeft(x - i, y)) {
                if (i == flameLength - 1) {
                    Flame flameleft = new Flame(x - (i + 1), y,
                            Sprite.explosion_horizontal_left_last.getFxImage());
                    BombermanGame.flame.add(flameleft);
                    flameleft.setImg(Sprite.movingSprite(Sprite.explosion_horizontal_left_last,
                            Sprite.explosion_horizontal_left_last1, Sprite.explosion_horizontal_left_last2,
                            countToExploded, decayTimer).getFxImage());
                } else {
                    Flame flameleft = new Flame(x - (i + 1), y,
                            Sprite.explosion_horizontal.getFxImage());
                    BombermanGame.flame.add(flameleft);
                    flameleft.setImg(Sprite.movingSprite(Sprite.explosion_horizontal,
                            Sprite.explosion_horizontal1, Sprite.explosion_horizontal2,
                            countToExploded, decayTimer).getFxImage());
                }
            } else break;
        }
        for (int i = 0; i < flameLength; i++) {
            if (canFireRight(x + i, y)) {
                if (i == flameLength - 1) {
                    Flame flameright = new Flame(x + (i + 1), y,
                            Sprite.explosion_horizontal_right_last.getFxImage());
                    BombermanGame.flame.add(flameright);
                    flameright.setImg(Sprite.movingSprite(Sprite.explosion_horizontal_right_last,
                            Sprite.explosion_horizontal_right_last1, Sprite.explosion_horizontal_right_last2,
                            countToExploded, decayTimer).getFxImage());
                } else {
                    Flame flameright = new Flame(x + (i + 1), y,
                            Sprite.explosion_horizontal.getFxImage());
                    BombermanGame.flame.add(flameright);
                    flameright.setImg(Sprite.movingSprite(Sprite.explosion_horizontal,
                            Sprite.explosion_horizontal1, Sprite.explosion_horizontal2,
                            countToExploded, decayTimer).getFxImage());
                }
            } else break;
        }
    }
}
