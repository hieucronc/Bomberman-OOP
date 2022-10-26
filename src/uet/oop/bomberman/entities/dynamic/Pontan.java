package uet.oop.bomberman.entities.dynamic;

import javafx.scene.image.Image;
import uet.oop.bomberman.controller.Movement;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.blocks.Brick;
import uet.oop.bomberman.entities.items.Items;
import uet.oop.bomberman.graphics.Sprite;
import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.entities.blocks.Bomb.decayTimer;

import java.util.Random;

public class Pontan extends Enemy {
    public static int pontanStep = 1;
    private int countPontanDead = 0;
    private int dir = DOWN;

    public Pontan(int x, int y, Image img) {
        super(x, y, img);
    }
    private boolean cUp() {
        for (Entity entity : block) {
            if (!(entity instanceof Brick) && !(entity instanceof Items)) {
                if (Movement.collision(this, this.getX(), this.getY() - pontanStep, entity.getX(), entity.getY())) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean cDown() {
        for (Entity entity : block) {
            if (!(entity instanceof Brick) && !(entity instanceof Items)) {
                if (Movement.collision(this, this.getX(), this.getY() + pontanStep, entity.getX(), entity.getY())) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean cRight() {
        for (Entity entity : block) {
            if (!(entity instanceof Brick) && !(entity instanceof Items)) {
                if (Movement.collision(this, this.getX() + pontanStep, this.getY(), entity.getX(), entity.getY())) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean cLeft() {
        for (Entity entity : block) {
            if (!(entity instanceof Brick) && !(entity instanceof Items)) {
                if (Movement.collision(this, this.getX() - pontanStep, this.getY(), entity.getX(), entity.getY())) {
                    return false;
                }
            }
        }
        return true;
    }
    private void mUp() {
        this.setImg(Sprite.movingSprite(Sprite.pontan_right1,Sprite.pontan_right2,Sprite.pontan_right3,this.getY(),100).getFxImage());
        if(cUp()) {
            this.setY(this.getY() - pontanStep);
        }
    }
    private void mDown() {
        this.setImg(Sprite.movingSprite(Sprite.pontan_left1,Sprite.pontan_left2,Sprite.pontan_left3,this.getY(),100).getFxImage());
        if(cDown()) {
            this.setY(this.getY() + pontanStep);
        }
    }
    private void mLeft() {
        this.setImg(Sprite.movingSprite(Sprite.pontan_left1,Sprite.pontan_left2,Sprite.pontan_left3,this.getX(),100).getFxImage());
        if (cLeft()) {
            this.setX(this.getX() - pontanStep);
        }
    }
    private void mRight() {
        this.setImg(Sprite.movingSprite(Sprite.pontan_right1,Sprite.pontan_right2,Sprite.pontan_right3,this.getX(),100).getFxImage());
        if (cRight()) {
            this.setX(this.getX() + pontanStep);
        }
    }
    public void pontanMove() {
        switch (dir) {
            case UP:
                if (cUp()) {
                    mUp();
                } else {
                    Random random = new Random();
                    dir = random.nextInt(4);
                }
                break;
            case DOWN:
                if (cDown()) {
                    mDown();
                } else {
                    Random random = new Random();
                    dir = random.nextInt(4);
                }
                break;
            case LEFT:
                if (cLeft()) {
                    mLeft();
                } else {
                    Random random = new Random();
                    dir = random.nextInt(4);
                }
                break;
            case RIGHT:
                if (cRight()) {
                    mRight();
                } else {
                    Random random = new Random();
                    dir = random.nextInt(4);
                }
                break;

        }
    }

    public void killPontan() {
        this.setImg(Sprite.movingSprite(Sprite.pontan_dead,
                Sprite.mob_dead1, Sprite.mob_dead2, Sprite.mob_dead3, countPontanDead, decayTimer * 4 / 3).getFxImage());
        countPontanDead++;
        if (countPontanDead > decayTimer * 4 / 3) {
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
            pontanMove();
        }
        checkAlive();
        if (!life) {
            killPontan();
        }
    }
}
