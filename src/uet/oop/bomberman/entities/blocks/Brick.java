package uet.oop.bomberman.entities.blocks;

import javafx.scene.image.Image;
import uet.oop.bomberman.controller.Movement;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.*;

public class Brick extends Entity {
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
        for (int i = 0; i < block.size(); i++) {
            if (block.get(i) instanceof Brick) {
                if (block.get(i).getX() == this.x && block.get(i).getY() == this.y) {
                    position[this.x / 32][this.y / 32] = 0;
                    Entity object = new Grass(this.x / 32, this.y / 32, Sprite.grass.getFxImage());
                    entities.add(object);
                    block.remove(i);
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
