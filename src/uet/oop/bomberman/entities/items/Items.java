package uet.oop.bomberman.entities.items;

import uet.oop.bomberman.controller.Movement;
import uet.oop.bomberman.entities.Entity;
import javafx.scene.image.Image;
import uet.oop.bomberman.entities.dynamic.Bomber;

import static uet.oop.bomberman.BombermanGame.*;
public abstract class Items extends Entity {
    public Items(int x, int y, Image image) {
        super(x,y,image);
    }
    public boolean checkBomb() {
        for (Entity entity : flame) {
            if (Movement.collision(entity.getX(), entity.getY(), this.getX(), this.getY())) {
                return true;
            }
        }
        return false;
    }
    public boolean takeItem() {
        for (Entity entity : entities) {
            if (entity instanceof Bomber) {
                if (Movement.collision(entity.getX(), entity.getY(), this.getX(), this.getY())) {

                    return true;
                }
            }
        }
        return false;
    }
}
