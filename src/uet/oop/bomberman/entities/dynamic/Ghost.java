package uet.oop.bomberman.entities.dynamic;

import javafx.scene.image.Image;
import uet.oop.bomberman.controller.Movement;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.blocks.Brick;
import uet.oop.bomberman.entities.blocks.Wall;
import uet.oop.bomberman.entities.items.Items;
import uet.oop.bomberman.entities.items.Portal;
import uet.oop.bomberman.graphics.Sprite;
import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.entities.blocks.Bomb.decayTimer;

import java.util.Random;

public class Ghost extends Enemy {
    public static int ghostStep = 1;
    private int countGhostDead = 0;
    private int dir = DOWN;

    public Ghost(int x, int y, Image img) {
        super(x, y, img);
    }
    private boolean cUp() {
        for (Entity entity : block) {
            if (!(entity instanceof Brick) && !(entity instanceof Items)) {
                if (Movement.collision(this, this.getX(), this.getY() - ghostStep, entity.getX(), entity.getY())) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean cDown() {
        for (Entity entity : block) {
            if (!(entity instanceof Brick) && !(entity instanceof Items)) {
                if (Movement.collision(this, this.getX(), this.getY() + ghostStep, entity.getX(), entity.getY())) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean cRight() {
        for (Entity entity : block) {
            if (!(entity instanceof Brick) && !(entity instanceof Items)) {
                if (Movement.collision(this, this.getX() + ghostStep, this.getY(), entity.getX(), entity.getY())) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean cLeft() {
        for (Entity entity : block) {
            if (!(entity instanceof Brick) && !(entity instanceof Items)) {
                if (Movement.collision(this, this.getX() - ghostStep, this.getY(), entity.getX(), entity.getY())) {
                    return false;
                }
            }
        }
        return true;
    }
    private void mUp() {
        this.setImg(Sprite.movingSprite(Sprite.ghost_right1,Sprite.ghost_right2,Sprite.ghost_right3,this.getY(),100).getFxImage());
        if(cUp()) {
            this.setY(this.getY() - ghostStep);
        }
    }
    private void mDown() {
        this.setImg(Sprite.movingSprite(Sprite.ghost_left1,Sprite.ghost_left2,Sprite.ghost_left3,this.getY(),100).getFxImage());
        if(cDown()) {
            this.setY(this.getY() + ghostStep);
        }
    }
    private void mLeft() {
        this.setImg(Sprite.movingSprite(Sprite.ghost_left1,Sprite.ghost_left2,Sprite.ghost_left3,this.getY(),100).getFxImage());
        if (cLeft()) {
            this.setX(this.getX() - ghostStep);
        }
    }
    private void mRight() {
        this.setImg(Sprite.movingSprite(Sprite.ghost_right1,Sprite.ghost_right2,Sprite.ghost_right3,this.getY(),100).getFxImage());
        if (cRight()) {
            this.setX(this.getX() + ghostStep);
        }
    }
    public void ghostMove() {
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

    public void killGhost() {
        this.setImg(Sprite.movingSprite(Sprite.ghost_dead,
                Sprite.mob_dead1, Sprite.mob_dead2, Sprite.mob_dead3, countGhostDead, decayTimer * 4 / 3).getFxImage());
        countGhostDead++;
        if (countGhostDead > decayTimer * 4 / 3) {
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
            ghostMove();
        }
        checkAlive();
        if (!life) {
            killGhost();
        }
    }
}
