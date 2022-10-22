package uet.oop.bomberman.entities.items;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.blocks.Flame;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.items;

public class FlameItem extends Items {
    public FlameItem(int x, int y, Image image) {
        super(x, y, image);
    }
    public static void useFlameItem() {
        Flame.flameLength++;
    }
    @Override
    public void update() {
        if (checkBomb()) {
            broken = true;
            reveal(Sprite.powerup_flames.getFxImage(),1);
        }
        if (takeItem()) {
            items.remove(isInItem(this));
            useFlameItem();
        }

    }

}
