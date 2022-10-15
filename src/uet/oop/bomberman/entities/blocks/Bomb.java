package uet.oop.bomberman.entities.blocks;

import javafx.scene.image.Image;

import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.controller.Movement;
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
    static int count = 0;
    private boolean exploded = false;
    public static boolean canPassThrough = true;
    public static int MAX_BOMB = 1;


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
        count++;
        if (!exploded) {
            this.setImg(Sprite.movingSprite(Sprite.bomb, Sprite.bomb_1,
                    Sprite.bomb_2, count, explodeTimer / 2).getFxImage());
//            if (canPassThrough) {
//                for (int i=0;i<entities.size();i++) {
//                    if (entities.get(i) instanceof Bomber) {
//                        if (!Movement.collision(this.getX(),this.getY(),entities.get(i).getX(),entities.get(i).getY())) {
//                            canPassThrough = false;
//                            break;
//                        }
//                    }
//                }
//
//            }
//            if (!canPassThrough) {
//                if (!block.contains(this)) {
//                    block.add(this);
//                }
//
//            }
            if (count > explodeTimer) {
                exploded = true;
                count = 0;
//                block.remove(this);
            }
        }
        if (exploded) {
            explode();
            if (count > decayTimer) {
                remove();
            }
        }

    }

    public void remove() {
        bombs.remove(0);
        flame.clear();

    }

    /**
     *
     */

    public static void placeBomb() {
        if (bombs.size() < MAX_BOMB) {
            count = 0;
            x = BombermanGame.bomberman.getX() / Sprite.SCALED_SIZE;
            y = BombermanGame.bomberman.getY() / Sprite.SCALED_SIZE;
            x = Math.round(x);
            y = Math.round(y);
            Bomb bomb = new Bomb(x, y, Sprite.bomb.getFxImage());
            BombermanGame.bombs.add(bomb);
        }

    }

}
