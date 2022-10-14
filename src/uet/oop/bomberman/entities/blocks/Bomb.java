package uet.oop.bomberman.entities.blocks;

import javafx.scene.image.Image;

import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.entities.AnimatedEntity;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.dynamic.Bomber;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.gc;

public class Bomb extends Entity {
    public static int x;
    public static int y;
    private boolean allowToWalkOn = true;
    int count = 0;
    private boolean exploded = false;


    public Bomb(int x, int y, Image boom) {
        super(x, y, boom);
    }

    protected void explode() {
        this.setImg(Sprite.movingSprite(Sprite.bomb_exploded, Sprite.bomb_exploded1, Sprite.bomb_exploded2, count, 120).getFxImage());
        count++;
        Flame.fireFlame(x, y);
    }

    /**
     *
     */
    @Override
    public void update() {
//        if (System.currentTimeMillis() - bombplacetime > timeToExplode)
//            explode();
//        long explodeTime = System.currentTimeMillis();
//        if (System.currentTimeMillis() - explodeTime > decayTimer) {
//            for (int i = 0; i < 5; i++)
//            BombermanGame.entities.remove(BombermanGame.entities.size() - 1);
//        }
        if (!exploded) {
            this.setImg(Sprite.movingSprite(Sprite.bomb, Sprite.bomb_1, Sprite.bomb_2, count, 120).getFxImage());
            count++;
//            gc.drawImage(img,x,y);
            if (count > 120) {
                exploded = true;
                count = 0;
            }
        }
        if (exploded) {
            explode();
        }

    }

    public void remove() {

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
