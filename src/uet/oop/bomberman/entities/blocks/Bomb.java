package uet.oop.bomberman.entities.blocks;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.entities.AnimatedEntity;
import uet.oop.bomberman.entities.dynamic.Bomber;
import uet.oop.bomberman.graphics.Sprite;

public class Bomb extends AnimatedEntity {
    public static long bombplacetime;
    private boolean allowToWalkOn = true;
    private boolean exploded = false;
    private static final int decayTimer =  500;
    private static final int timeToExplode = 2000; // 2000 milisec = 2 sec
    public Bomb(int x, int y, Image boom) {
        super(x, y, boom);
    }

    protected void explode() {
        setImg(Sprite.bomb_exploded.getFxImage());
    }

    /**
     *
     */
    @Override
    public void update() {
        if (System.currentTimeMillis() - bombplacetime > timeToExplode)
                explode();
        long explodeTime = System.currentTimeMillis();
        if (System.currentTimeMillis() - explodeTime > decayTimer)
            BombermanGame.entities.remove(BombermanGame.entities.size());
    }

    /**
     *
     */
    @Override
    public void playAnimation() {
//        if (exploded) {
//            img = Sprite.movingSprite(Sprite.bomb_exploded,
//                    Sprite.bomb_exploded1, Sprite.bomb_exploded2, 90, 30).getFxImage();
//        } else {
//            img = Sprite.movingSprite(Sprite.bomb
//                    , Sprite.bomb_1, Sprite.bomb_2, timeToExplode, 50).getFxImage();
//        }
    }

    public static void placeBomb() {
        int x = BombermanGame.bomberman.getX() / 32;
        int y = BombermanGame.bomberman.getY() / 32;
        x = Math.round(x);
        y = Math.round(y);
        Bomb bomb = new Bomb(x, y, Sprite.bomb.getFxImage());
        BombermanGame.entities.add(bomb);
        bombplacetime = System.currentTimeMillis();
    }

}
