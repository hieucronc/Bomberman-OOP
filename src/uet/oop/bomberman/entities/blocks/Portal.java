package uet.oop.bomberman.entities.blocks;

import javafx.scene.image.Image;
import uet.oop.bomberman.controller.Movement;
import uet.oop.bomberman.entities.Entity;

import static uet.oop.bomberman.BombermanGame.flame;

public class Portal extends Entity {
    public Portal(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }
    public boolean checkBomb() {
        for (Entity entity : flame) {
            if (Movement.collision(entity, entity.getX(), entity.getY(), this.getX(), this.getY())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void update() {

    }
}
