package uet.oop.bomberman.entities.blocks;

import javafx.scene.image.Image;
import uet.oop.bomberman.controller.Movement;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.*;

public class Brick extends Entity {
    public static int cntBrickExploded = 0;
    public Brick(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    public boolean checkBomb() {
        for (Entity entity : flame) {
            if (entity.getX() == this.getX() && entity.getY() == this.getY()) {
                return true;
            }
        }
        return false;
    }

    public void removeBrick() {
        this.setImg(Sprite.movingSprite(Sprite.brick_exploded,Sprite.brick_exploded1,Sprite.brick_exploded2,cntBrickExploded,50).getFxImage());
        cntBrickExploded++;
        if (cntBrickExploded > 20) {
            for (int i = 0; i < block.size(); i++) {
                if (block.get(i) instanceof Brick) {
                    if (((Brick) block.get(i)).checkBomb()) {
                        block.remove(i);
                    }
                }

            }
        }


    }

    @Override
    public void update() {
        if (checkBomb()) {
            removeBrick();
        }
    }
}
