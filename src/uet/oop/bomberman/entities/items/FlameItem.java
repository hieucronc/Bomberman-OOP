package uet.oop.bomberman.entities.items;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.blocks.Flame;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.items;
import static uet.oop.bomberman.BombermanGame.position;

public class FlameItem extends Items {
    public FlameItem(int x, int y, Image image) {
        super(x, y, image);
    }
    public static void useFlameItem() {
        Flame.flameLength++;
    }
    public static void resetFlameItem() {
        Flame.flameLength = 1;
    }
    @Override
    public void update() {
        if (checkBomb()) {
            broken = true;
            reveal(Sprite.powerup_flames.getFxImage(),1);
            position[this.getY() / Sprite.SCALED_SIZE][this.getX() / Sprite.SCALED_SIZE] = 0;
        }
        if (takeItem()) {
            items.remove(isInItem(this));
            useFlameItem();
        }

    }

}
