package uet.oop.bomberman.entities.items;

import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.block;

public class Portal extends Items {

    public Portal(int x, int y, Image image) {
        super(x, y, image);
    }

    @Override
    public void update() {
        if (checkBomb()) {
            broken = true;
            reveal(Sprite.portal.getFxImage(),2);
        }
        if (takeItem()) {

        }

    }
}
