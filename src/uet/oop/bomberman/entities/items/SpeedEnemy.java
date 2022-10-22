package uet.oop.bomberman.entities.items;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.dynamic.Doll;
import uet.oop.bomberman.entities.dynamic.Kondoria;
import uet.oop.bomberman.entities.dynamic.Minvo;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.entities.dynamic.Bomber.bomberStep;

public class SpeedEnemy extends Items{
    public SpeedEnemy(int x, int y, Image img) {
        super(x,y,img);
    }
    public static void useSpeedEnemy() {
        Doll.dollStep = 2;
        Kondoria.kondoriaStep = 2;
        Minvo.minvoStep = 2;
    }
    @Override
    public void update() {
        if (checkBomb()) {
            broken = true;
            reveal(Sprite.enemy_powerup.getFxImage(),1);
        }
        if (takeItem()) {
            items.remove(isInItem(this));
            useSpeedEnemy();
        }
    }
}
