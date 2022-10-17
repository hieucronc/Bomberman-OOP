package uet.oop.bomberman.entities.dynamic;

import javafx.scene.image.Image;
import uet.oop.bomberman.controller.Movement;
import uet.oop.bomberman.entities.Entity;
import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.controller.Movement.*;
public abstract class DynamicEntities extends Entity {
    protected boolean life = true;
    public DynamicEntities() {

    }
    public void checkBomb() {
        for (Entity entity : flame) {
            if (Movement.collision(this, this.getX(), this.getY(), entity.getX(), entity.getY())) {
                this.life = false;
                break;
            }
        }
    }
    public DynamicEntities(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }


}
