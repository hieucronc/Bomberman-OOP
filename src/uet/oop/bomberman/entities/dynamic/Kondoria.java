package uet.oop.bomberman.entities.dynamic;

import javafx.scene.image.Image;
import uet.oop.bomberman.controller.Movement;
import uet.oop.bomberman.graphics.Sprite;

import java.util.Random;

import static uet.oop.bomberman.entities.blocks.Bomb.*;
import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.controller.Movement.*;

public class Kondoria extends Enemy {
    public static int kondoriaStep = 1;
    public static boolean etheral = false;
    private int timer = 0;
    private int stateTimer = 300;
    private int countKondoriaDead = 0;

    public Kondoria(int x, int y, Image img) {
        super(x, y, img);
    }

    private int dir = DOWN;

    public void kondoriaMove() {
        if (!etheral) {
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
        } else {
            if (bomberman.getY() < this.getY()) {
                this.setImg(Sprite.kondoria_left1.getFxImage());
                moveUp(this);
            }
            if (bomberman.getY() > this.getY()) {
                this.setImg(Sprite.kondoria_right1.getFxImage());
                moveDown(this);
            }
            if (bomberman.getX() > this.getX()) {
                this.setImg(Sprite.kondoria_right1.getFxImage());
                moveRight(this);
            }
            if (bomberman.getX() < this.getX()) {
                this.setImg(Sprite.kondoria_left1.getFxImage());
                moveLeft(this);
            }
        }


    }

    public void killKondoria() {
        this.setImg(Sprite.movingSprite(Sprite.kondoria_dead, Sprite.mob_dead1, Sprite.mob_dead2,
                Sprite.mob_dead3, countKondoriaDead, decayTimer * 4 / 3).getFxImage());
        countKondoriaDead++;
        if (countKondoriaDead > decayTimer * 4 / 3) {
            for (int i = 0; i < enemy.size(); i++) {
                if (enemy.get(i).getX() == this.getX() && enemy.get(i).getY() == this.getY()) {
                    enemy.remove(i);
                }
            }
        }
    }

    public void switchState() {
        if (timer > stateTimer) {
            if (canMoveDown(this) || canMoveUp(this)
                    || canMoveLeft(this) || canMoveRight(this)) {
                if (etheral) {
                    setstateTimer();
                    etheral = false;
                    timer = 0;
                } else {
                    setstateTimer();
                    etheral = true;
                    timer = 0;
                }
            }
        }
    }

    public void setstateTimer() {
        if (etheral) setTimer();
        else setEtheralTimer();
    }

    public void setEtheralTimer() {
        Random rand = new Random();
        int ranNum;
        ranNum = rand.nextInt(3);
        stateTimer = ranNum * 60;
    }

    public void setTimer() {
        Random rand = new Random();
        int ranNum = 0;
        while (ranNum < 5)
            ranNum = rand.nextInt(11);
        stateTimer = ranNum * 60;
    }

    @Override
    public void update() {
        timer++;
        switchState();
        if (life)
            kondoriaMove();
        checkAlive();
        if (!life) {
            killKondoria();
        }
    }
}
