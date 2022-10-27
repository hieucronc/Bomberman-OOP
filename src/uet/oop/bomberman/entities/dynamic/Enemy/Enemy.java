package uet.oop.bomberman.entities.dynamic.Enemy;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.dynamic.DynamicEntities;

public abstract class Enemy extends DynamicEntities {

    public static final int UP = 0;
    public static final int DOWN = 1;
    public static final int LEFT = 2;
    public static final int RIGHT = 3;

    public Enemy(int x, int y, Image img) {
        super(x, y, img);
    }

}
