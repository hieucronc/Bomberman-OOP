package uet.oop.bomberman.entities.dynamic;

import javafx.scene.image.Image;
import uet.oop.bomberman.controller.Movement;
import uet.oop.bomberman.graphics.Sprite;
import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.entities.blocks.Bomb.decayTimer;

import java.util.Random;

public class Ballom extends DynamicEntities {
    public static int ballomStep = 1;
    private int tick = 0;
    private int dir;
    private int countBallomDead = 0;
    private static final int UP = 0;
    private static final int DOWN = 1;
    private static final int LEFT = 2;
    private static final int RIGHT = 3;
    public Ballom(int x, int y, Image img) {
        super(x,y,img);
    }
    public void enemyMove() {
//        if (dir == UP && !Movement.canMoveUp(this) && tick <= 70) {
//            while (dir == UP) {
//                Random random = new Random();
//                dir = random.nextInt(4);
//            }
//        }
//        if (dir == DOWN && !Movement.canMoveDown(this) && tick <= 70) {
//            while (dir == DOWN) {
//                Random random = new Random();
//                dir = random.nextInt(4);
//            }
//        }
//        if (dir == LEFT && !Movement.canMoveLeft(this) && tick <= 70) {
//            while (dir == LEFT) {
//                Random random = new Random();
//                dir = random.nextInt(4);
//            }
//        }
//        if (dir == RIGHT && !Movement.canMoveRight(this) && tick <= 70) {
//            while (dir == RIGHT) {
//                Random random = new Random();
//                dir = random.nextInt(4);
//            }
//        }
        if (tick > 60) {
            Random random = new Random();
            dir = random.nextInt(4);
            tick = 0;
        }

        switch (dir) {
            case UP:
                if (Movement.canMoveUp(this)) {
                    Movement.moveUp(this);
                } else {
                    tick = 71;
                }

                break;
            case DOWN:
                if (Movement.canMoveDown(this)) {
                    Movement.moveDown(this);
                } else {
                    tick = 71;
                }
                break;
            case LEFT:
                if (Movement.canMoveLeft(this)) {
                    Movement.moveLeft(this);
                } else {
                    tick = 71;
                }
                break;
            case RIGHT:
                if (Movement.canMoveRight(this)) {
                    Movement.moveRight(this);
                } else {
                    tick = 71;
                }
                break;

        }
    }

    public void killBallom() {
        this.setImg(Sprite.movingSprite(Sprite.balloom_dead,Sprite.balloom_dead,Sprite.balloom_dead,countBallomDead,60).getFxImage());
        countBallomDead++;
        if (countBallomDead > decayTimer)  {
            for (int i=0;i<enemy.size();i++) {
                if (enemy.get(i).getX() == this.getX() && enemy.get(i).getY() == this.getY()) {
                    enemy.remove(i);
                }
            }
        }
    }

    @Override
    public void update() {
        tick++;
//        if (tick > 1e6) {
//            tick = 0;
//        }
        enemyMove();
        checkBomb();
        if (!life) {
            killBallom();
        }
    }
}
