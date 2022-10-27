package uet.oop.bomberman.entities.items;

import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.*;

public class BombPassItem extends Items {
    public static boolean takeBombPass = false;

    public static void useBombPassItem() {
        takeBombPass = true;
    }

    public static void resetBombPass() {
        takeBombPass = false;
    }

    public BombPassItem(int x, int y, Image image) {
        super(x, y, image);
    }

    @Override
    public void update() {
        if (checkBomb()) {
            broken = true;
            reveal(Sprite.powerup_bombpass.getFxImage(), 1);
            position[this.getY() / Sprite.SCALED_SIZE][this.getX() / Sprite.SCALED_SIZE] = 0;
        }
        if (takeItem()) {
            items.remove(isInItem(this));
            useBombPassItem();
        }
    }
}
