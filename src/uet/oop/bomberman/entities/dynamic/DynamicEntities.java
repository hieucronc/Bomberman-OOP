package uet.oop.bomberman.entities.dynamic;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Entity;
public abstract class DynamicEntities extends Entity {
    protected boolean life = true;

    public void checkAlive() {
        if (checkBomb()) this.life = false;
    }
    public DynamicEntities(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }


}
