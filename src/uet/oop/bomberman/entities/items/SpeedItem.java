package uet.oop.bomberman.entities.items;

import uet.oop.bomberman.entities.Entity;
import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;
import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.entities.dynamic.Bomber.*;
public class SpeedItem extends Items {
    public SpeedItem(int x, int y, Image image) {
        super(x,y,image);
    }
    @Override
    public void update() {
        if (checkBomb()) {
            img = Sprite.powerup_speed.getFxImage();
            block.remove(isInBlock(this));
        }
        if (takeItem()) {
            items.remove(isInItem(this));
            bomberStep = 3;
        }
    }
}
