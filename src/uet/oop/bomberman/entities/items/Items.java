package uet.oop.bomberman.entities.items;

import uet.oop.bomberman.controller.Movement;
import uet.oop.bomberman.entities.Entity;
import javafx.scene.image.Image;
import uet.oop.bomberman.entities.dynamic.Bomber;
import uet.oop.bomberman.graphics.Sprite;

import java.awt.font.ImageGraphicAttribute;

import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.entities.blocks.Bomb.decayTimer;

public abstract class Items extends Entity {
    boolean broken = false;
    int cntBrickExploded = 0;

    public Items(int x, int y, Image image) {
        super(x, y, image);
    }

    public void reveal(Image _itemImage) {
        if (broken) {
            this.setImg(Sprite.movingSprite(Sprite.brick_exploded, Sprite.brick_exploded1,
                    Sprite.brick_exploded2, cntBrickExploded, decayTimer).getFxImage());
            cntBrickExploded++;
            if (cntBrickExploded > decayTimer) {
                img = _itemImage;
                for (int i = 0; i < block.size(); i++) {
                    if (block.get(i).getX() == this.getX() && block.get(i).getY() == this.getY()) {
                        block.remove(i);
                    }
                }
            }
        }
    }

    public boolean takeItem() {
        for (Entity entity : entities) {
            if (entity instanceof Bomber) {
                if (Movement.collision(entity, entity.getX(), entity.getY(), this.getX(), this.getY())) {
                    return true;
                }
            }
        }
        return false;
    }
}
