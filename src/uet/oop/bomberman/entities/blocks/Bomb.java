package uet.oop.bomberman.entities.blocks;

import javafx.scene.image.Image;

import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.entities.AnimatedEntity;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.dynamic.Bomber;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.*;

public class Bomb extends Entity {
    public static int x;
    public static int y;
    private boolean allowToWalkOn = true;
    public static final int explodeTimer = 120;
    public static final int decayTimer = 30;
    int count = 0;
    private boolean exploded = false;


    public Bomb(int x, int y, Image boom) {
        super(x, y, boom);
    }

    protected void explode() {
        Flame.fireFlame(x, y);
    }

    /**
     *
     */
    @Override
    public void update() {
        if (!exploded) {
            this.setImg(Sprite.movingSprite(Sprite.bomb, Sprite.bomb_1, Sprite.bomb_2, count, explodeTimer).getFxImage());
            count++;
//            gc.drawImage(img,x,y);
            if (count > explodeTimer) {
                exploded = true;
                count = 0;
            }
        }
        if (exploded) {
            explode();
            count++;
            if (count > decayTimer) {
                remove();
            }
        }

    }

    public void remove() {
            flame.clear();
            entities.remove(entities.size()-1);
    }
    /**
     *
     */

    public static void placeBomb() {
        x = BombermanGame.bomberman.getX() / 32;
        y = BombermanGame.bomberman.getY() / 32;
        x = Math.round(x);
        y = Math.round(y);
        Bomb bomb = new Bomb(x, y, Sprite.bomb.getFxImage());
        BombermanGame.entities.add(bomb);
//        bomb.setImg(Sprite.movingSprite(Sprite.bomb,Sprite.bomb_1,Sprite.bomb_2,frameCount,100).getFxImage());
//        updateFrameCount();
//        gc.drawImage(img,x,y);
//        bombplacetime = System.currentTimeMillis();
    }

}
