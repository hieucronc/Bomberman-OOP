package uet.oop.bomberman.entities.items;

import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;

import java.util.Random;

import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.entities.items.BombPassItem.useBombPassItem;
import static uet.oop.bomberman.entities.items.CounterSpeed.*;
import static uet.oop.bomberman.entities.items.FlameItem.*;
import static uet.oop.bomberman.entities.items.FlamePassItem.*;
import static uet.oop.bomberman.entities.items.SpeedItem.*;
import static uet.oop.bomberman.entities.items.SpeedEnemy.*;


public class RandomItem extends Items{
    public RandomItem(int x, int y, Image img) {
        super(x,y,img);
    }
    private void useItem() {
        Random random = new Random();
        int item = random.nextInt(7);
        switch (item) {
            case 0:
                useBombPassItem();
                break;
            case 1:
                useCounterSpeed();
                break;
            case 2:
                useFlameItem();
                break;
            case 3:
                useFlamePassItem();
                break;
            case 4:
                useSpeedEnemy();
                break;
            case 5:
                useSpeedItem();
                break;
        }
    }
    @Override
    public void update() {
        if (checkBomb()) {
            broken = true;
            reveal(Sprite.random_item.getFxImage(),1);
            position[this.getY() / Sprite.SCALED_SIZE][this.getX() / Sprite.SCALED_SIZE] = 0;
        }
        if (takeItem()) {
            items.remove(isInItem(this));
            useItem();
        }
    }
}
