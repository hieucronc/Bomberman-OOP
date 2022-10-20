package uet.oop.bomberman.entities.dynamic;

import javafx.scene.image.Image;
import uet.oop.bomberman.controller.Movement;
import uet.oop.bomberman.graphics.Sprite;

import java.util.Random;

import static uet.oop.bomberman.entities.blocks.Bomb.*;
import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.controller.Movement.*;

public class Kondoria extends DynamicEntities {
    public static int kondoriaStep = 1;
    public static boolean etheral = false;
    private int timer = 0;
    private int stateTimer = 0;
    private int countKondoriaDead = 0;

    public Kondoria(int x, int y, Image img) {
        super(x, y, img);
    }

    private int dir = DOWN;
    private static final int UP = 0;
    private static final int DOWN = 1;
    private static final int LEFT = 2;
    private static final int RIGHT = 3;

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
            if (etheral) etheral = false;
            else etheral = true;
        }
    }

    public void stateTimer() {
        Random rand = new Random();
        int ranNum = 0;
        while (ranNum < 2)
            ranNum = rand.nextInt(7);
        stateTimer = ranNum;
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
