package uet.oop.bomberman.entities.dynamic;

import javafx.scene.image.Image;
import uet.oop.bomberman.controller.Movement;
import uet.oop.bomberman.graphics.Sprite;

import java.util.Random;

import static uet.oop.bomberman.BombermanGame.bomberman;
import static uet.oop.bomberman.BombermanGame.enemy;
import static uet.oop.bomberman.entities.blocks.Bomb.decayTimer;

public class Minvo extends Enemy {
    public static int minvoStep = 1;
    private int dir = DOWN;
    private int countMinvoDead = 0;

    public Minvo(int x, int y, Image img) {
        super(x, y, img);
    }

    public void minvoMove() {
        if (Math.abs(bomberman.getX() - this.getX()) <= 8 && Math.abs(bomberman.getY() - this.getY()) < 5 * Sprite.SCALED_SIZE) {
            if (bomberman.getY() > this.getY()) {
                Movement.moveUp(this);
            } else if (bomberman.getY() < this.getY()) {
                Movement.moveDown(this);
            }
        } else if (bomberman.getY() == this.getY() && Math.abs(bomberman.getX() - this.getX()) < 5 * Sprite.SCALED_SIZE) {
            if (bomberman.getX() > this.getX()) {
                Movement.moveLeft(this);
            } else if (bomberman.getX() < this.getX()) {
                Movement.moveRight(this);
            }
        } else {
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
    }

    public void killMinvo() {
        this.setImg(Sprite.movingSprite(Sprite.minvo_dead, Sprite.mob_dead1, Sprite.mob_dead2,
                Sprite.mob_dead3, countMinvoDead, decayTimer * 4 / 3).getFxImage());
        countMinvoDead++;
        if (countMinvoDead > decayTimer * 4 / 3) {
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
        if (life)
            minvoMove();
        checkAlive();
        if (!life) {
            killMinvo();
        }
    }
}

