package uet.oop.bomberman.entities.blocks;

import javafx.scene.image.Image;

import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.controller.Movement;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.dynamic.Bomber;
import uet.oop.bomberman.graphics.Sprite;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

import static uet.oop.bomberman.entities.items.BombPassItem.*;
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
//    boolean soundExplosion = true;

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
    public void update() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        countToExploded++;
        if (!exploded) {
            this.setImg(Sprite.movingSprite(Sprite.bomb, Sprite.bomb_1,
                    Sprite.bomb_2, countToExploded, explodeTimer / 2).getFxImage());
            if (allowToWalkOn && !takeBombPass) {
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
//            if (soundExplosion) {
//                bomExplosion();
//                soundExplosion = false;
//            }
            if (countToExploded > decayTimer) {
                remove();
            }
        }

    }

    public void remove() {
        bombs.remove(0);
        flame.clear();
        if (!takeBombPass) {
            block.remove(block.size() - 1);
        }
        position[y][x] = 0;
    }

    /**
     *
     */

    public static void placeBomb() {
        if (bombs.size() < MAX_BOMB) {
            countToExploded = 0;
            double tmpX =(double) BombermanGame.bomberman.getX() / Sprite.SCALED_SIZE;
            double tmpY =(double) BombermanGame.bomberman.getY() / Sprite.SCALED_SIZE;
            x = (int) Math.round(tmpX);
            y = (int) Math.round(tmpY);
            Bomb bomb = new Bomb(x, y, Sprite.bomb.getFxImage());
            BombermanGame.bombs.add(bomb);
            position[y][x] = 3;
        }

    }

}
