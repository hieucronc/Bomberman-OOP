package uet.oop.bomberman.entities.dynamic;

import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;
import static uet.oop.bomberman.entities.blocks.Bomb.*;
import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.controller.Movement.*;
public class Minvo extends DynamicEntities {
    public static int minvoStep = 2;
    private int countMinvoDead = 0;
    public Minvo(int x, int y, Image img) {
        super(x, y, img);
    }
    public void minvoMove() {

    }
    public void killMinvo() {
        this.setImg(Sprite.movingSprite(Sprite.minvo_dead,Sprite.mob_dead1,Sprite.mob_dead2,countMinvoDead,60).getFxImage());
        countMinvoDead++;
        if (countMinvoDead > decayTimer) {
            for (int i=0;i<enemy.size();i++) {
                if (enemy.get(i).getX() == this.getX() && enemy.get(i).getY() == this.getY()) {
                    enemy.remove(i);
                }
            }
        }
    }
    @Override
    public void update() {
        minvoMove();
        checkAlive();
        if (!life) {
            killMinvo();
        }
    }
}

