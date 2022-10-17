package uet.oop.bomberman.entities.items;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.entities.blocks.Flame;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.block;
import static uet.oop.bomberman.BombermanGame.items;

public class Portal extends Items {

    public Portal(int x, int y, Image image) {
        super(x, y, image);
    }

    @Override
    public void update() {
        if (checkBomb()) {
            img = Sprite.portal.getFxImage();
            block.remove(isInBlock(this));
        }
        if (takeItem()) {

        }

    }
}