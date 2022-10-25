package uet.oop.bomberman.entities.items;

import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;
import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.entities.dynamic.Bomber.*;
public class CounterSpeed extends Items {
    public CounterSpeed(int x, int y, Image image) {
        super(x,y,image);
    }
    public static void useCounterSpeed() {
        bomberStep = 1;
    }
    @Override
    public void update() {
        if (checkBomb()) {
            broken = true;
            reveal(Sprite.counter_speed.getFxImage(),1);
            position[this.getY() / Sprite.SCALED_SIZE][this.getX() / Sprite.SCALED_SIZE] = 0;
        }

        if (takeItem()) {
            items.remove(isInItem(this));
            useCounterSpeed();
        }
    }
}
