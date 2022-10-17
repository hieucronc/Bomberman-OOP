package uet.oop.bomberman.entities.items;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.blocks.Flame;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.block;
import static uet.oop.bomberman.BombermanGame.items;
import static uet.oop.bomberman.entities.dynamic.Bomber.bomberStep;

public class FlameItem extends Items {
    public FlameItem(int x, int y, Image image) {
        super(x, y, image);
    }

    @Override
    public void update() {
        if (checkBomb()) {
            img = Sprite.powerup_flames.getFxImage();
            block.remove(isInBlock(this));
        }
        if (takeItem()) {
            items.remove(isInItem(this));
            Flame.flameLength++;
        }

    }

}
