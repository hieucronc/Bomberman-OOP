package uet.oop.bomberman.entities.dynamic.Enemy;

import javafx.scene.image.Image;
import uet.oop.bomberman.controller.Movement;
import uet.oop.bomberman.graphics.Sprite;

import java.util.Random;

import static uet.oop.bomberman.BombermanGame.enemy;
import static uet.oop.bomberman.entities.blocks.Bomb.decayTimer;

public class Ballom extends Enemy {
    public static int ballomStep = 1;
    private int countBallomDead = 0;
    private int dir = DOWN;

    public Ballom(int x, int y, Image img) {
        super(x, y, img);
    }

    public void ballomMove() {
        switch (dir) {
            case UP:
                if (Movement.canMoveUp(this)) {
                    Movement.moveUp(this);
                } else {
                    Random random = new Random();
                    dir = random.nextInt(4);
                }

                break;
            case DOWN:
                if (Movement.canMoveDown(this)) {
                    Movement.moveDown(this);
                } else {
                    Random random = new Random();
                    dir = random.nextInt(4);
                }
                break;
            case LEFT:
                if (Movement.canMoveLeft(this)) {
                    Movement.moveLeft(this);
                } else {
                    Random random = new Random();
                    dir = random.nextInt(4);
                }
                break;
            case RIGHT:
                if (Movement.canMoveRight(this)) {
                    Movement.moveRight(this);
                } else {
                    Random random = new Random();
                    dir = random.nextInt(4);
                }
                break;

        }
    }

    public void killBallom() {
        this.setImg(Sprite.movingSprite(Sprite.balloom_dead,
                Sprite.mob_dead1, Sprite.mob_dead2, Sprite.mob_dead3, countBallomDead, decayTimer * 4 / 3).getFxImage());
        countBallomDead++;
        if (countBallomDead > decayTimer * 4 / 3) {
            for (int i = 0; i < enemy.size(); i++) {
                if (enemy.get(i).getX() == this.getX() && enemy.get(i).getY() == this.getY()) {
                    enemy.remove(i);
                    break;
                }
            }
        }
    }

    @Override
    public void update() {
        if (life) {
            ballomMove();
        }
        checkAlive();
        if (!life) {
            killBallom();
        }
    }
}
