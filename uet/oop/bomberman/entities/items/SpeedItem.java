package uet.oop.bomberman.entities.items;

import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;
import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.entities.dynamic.Bomber.*;
public class SpeedItem extends Items {
    public SpeedItem(int x, int y, Image image) {
        super(x,y,image);
    }
    public static void useSpeedItem() {
        if (bomberman.getX() % 4 == 2) {
            bomberman.setX(bomberman.getX() - 2);
        }
        if (bomberman.getY() % 4 == 2) {
            bomberman.setY(bomberman.getY() - 2);
        }
        bomberStep++;
    }
    @Override
    public void update() {
        if (checkBomb()) {
            broken = true;
            reveal(Sprite.powerup_speed.getFxImage(),2);
            position[this.getY() / Sprite.SCALED_SIZE][this.getX() / Sprite.SCALED_SIZE] = 0;
        }

        if (takeItem()) {
            items.remove(isInItem(this));
            useSpeedItem();
        }
    }
}
