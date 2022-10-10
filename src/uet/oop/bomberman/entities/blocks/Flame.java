package uet.oop.bomberman.entities.blocks;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.dynamic.DynamicEntities;
import uet.oop.bomberman.graphics.Sprite;

import java.awt.*;

import static uet.oop.bomberman.BombermanGame.position;

public class Flame extends Entity {

    @Override
    public void update() {

    }

    public static boolean canFireDown(int x, int y) {
        return position[x][y + 1] == 0;
    }

    public static boolean canFireUp(int x, int y) {
        return position[x][y - 1] == 0;
    }

    public static boolean canFireLeft(int x, int y) {
        return position[x - 1][y] == 0;
    }

    public static boolean canFireRight(int x, int y) {
        return position[x + 1][y] == 0;
    }

    public Flame(int x, int y, Image _flame) {
        super(x, y, _flame);
    }
    public static void fireFlame(int x, int y) {
        if (canFireUp(x,y)) {
            Flame flameup = new Flame(x, y - 1, Sprite.explosion_vertical2.getFxImage());
            BombermanGame.entities.add(flameup);
        }
        if (canFireDown(x,y)) {
            Flame flamedown = new Flame(x, y + 1, Sprite.explosion_vertical_down_last2.getFxImage());
            BombermanGame.entities.add(flamedown);
        }
        if (canFireLeft(x,y)) {
            Flame flameleft = new Flame(x -1 , y, Sprite.explosion_horizontal_left_last2.getFxImage());
            BombermanGame.entities.add(flameleft);
        }
        if (canFireRight(x,y)) {
            Flame flameright = new Flame(x + 1, y , Sprite.explosion_horizontal_right_last2.getFxImage());
            BombermanGame.entities.add(flameright);
        }
    }
}
