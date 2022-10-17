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
    static int countToExploded = 0;
    private boolean exploded = false;
    public boolean canPassThrough = true;
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
        countToExploded++;
        if (!exploded) {
            this.setImg(Sprite.movingSprite(Sprite.bomb, Sprite.bomb_1,
                    Sprite.bomb_2, countToExploded, explodeTimer / 2).getFxImage());
            if (allowToWalkOn) {
                if (canPassThrough) {
                    for (Entity entity : entities) {
                        if (entity instanceof Bomber) {
                            if (!Movement.collision(entity, entity.getX(), entity.getY(), this.getX(), this.getY())) {
                                canPassThrough = false;
                                break;
                            }
                        }
                    }

                } else {
                    block.add(this);
                    allowToWalkOn = false;
                }
            }
            if (countToExploded > explodeTimer) {
                exploded = true;
                countToExploded = 0;

            }
        }
        if (exploded) {
            explode();
            if (countToExploded > decayTimer) {
                remove();
            }
        }

    }

    public void remove() {
        bombs.remove(0);
        flame.clear();
        block.remove(block.size() - 1);
    }

    /**
     *
     */

    public static void placeBomb() {
        if (bombs.size() < MAX_BOMB) {
            countToExploded = 0;
            double tmpX = BombermanGame.bomberman.getX() / Sprite.SCALED_SIZE;
            double tmpY = BombermanGame.bomberman.getY() / Sprite.SCALED_SIZE;
            x = (int) Math.round(tmpX);
            y = (int) Math.round(tmpY);
            Bomb bomb = new Bomb(x, y, Sprite.bomb.getFxImage());
            BombermanGame.bombs.add(bomb);
        }

    }

}
