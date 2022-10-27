package uet.oop.bomberman.entities.items;

import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.*;

public class DestroyItem extends Items {
    public static boolean destroyMode = false;

    public DestroyItem(int x, int y, Image image) {
        super(x, y, image);
    }

    public static void useDestroyItem() {
        destroyMode = true;
    }

    public static void resetDestroyItem() {
        destroyMode = false;
    }

    @Override
    public void update() {
        if (checkBomb()) {
            broken = true;
            reveal(Sprite.powerup_cleanse.getFxImage(), 1);
            position[this.getY() / Sprite.SCALED_SIZE][this.getX() / Sprite.SCALED_SIZE] = 0;
        }
        if (takeItem()) {
            items.remove(isInItem(this));
            useDestroyItem();
        }

    }
}
