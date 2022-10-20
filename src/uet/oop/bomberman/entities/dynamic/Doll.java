package uet.oop.bomberman.entities.dynamic;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.controller.Movement;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.controller.Movement.*;
import static uet.oop.bomberman.controller.Movement.moveLeft;
import static uet.oop.bomberman.entities.blocks.Bomb.decayTimer;

import java.util.Random;


public class Doll extends DynamicEntities {
    public static int dollStep = 1;
    private int dir = DOWN;
    private static final int UP = 0;
    private static final int DOWN = 1;
    private static final int LEFT = 2;
    private static final int RIGHT = 3;
    private int countDollDead = 0;

    public Doll(int x, int y, Image img) {
        super(x, y, img);
    }

    public double distance() {
        double tmpX = bomberman.getX() / Sprite.SCALED_SIZE;
        double tmpY = bomberman.getY() / Sprite.SCALED_SIZE;
        int _x = (int) Math.round(tmpX);
        int _y = (int) Math.round(tmpY);
        tmpX = x / Sprite.SCALED_SIZE;
        tmpY = y / Sprite.SCALED_SIZE;
        int _xx = (int) Math.round(tmpX);
        int _yx = (int) Math.round(tmpY);
        return Math.sqrt((_x - _xx) * (_x - _xx) + (_y - _yx) * (_y - _yx));
    }


    public void dollMove() {
        if (distance() > 5) {
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
        } else if (distance() > 1) {
            if (bomberman.getY() < this.getY()) {
                moveUp(this);
            }
            if (bomberman.getY() > this.getY()) {
                moveDown(this);
            }
            if (bomberman.getX() > this.getX()) {
                moveRight(this);
            }
            if (bomberman.getX() < this.getX()) {
                moveLeft(this);
            }
        } else {

        }
    }

    public void killDoll() {
        this.setImg(Sprite.movingSprite(Sprite.doll_dead, Sprite.mob_dead1, Sprite.mob_dead2, Sprite.mob_dead3, countDollDead, decayTimer * 4 / 3).getFxImage());
        countDollDead++;
        if (countDollDead > decayTimer * 4 / 3) {
            for (int i = 0; i < enemy.size(); i++) {
                if (enemy.get(i).getX() == this.getX() && enemy.get(i).getY() == this.getY()) {
                    enemy.remove(i);
                }
            }
        }
    }

    @Override
    public void update() {
        if (life)
            dollMove();
        checkAlive();
        if (!life) {
            killDoll();
        }
    }
}
