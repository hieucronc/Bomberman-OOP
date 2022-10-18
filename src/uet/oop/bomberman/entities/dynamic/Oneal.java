package uet.oop.bomberman.entities.dynamic;

import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.entities.blocks.Bomb.*;
import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.controller.Movement.*;

public class Oneal extends DynamicEntities {
    public static int onealStep = 2;
    private int countOnealDead = 0;

    public Oneal(int x, int y, Image img) {
        super(x, y, img);
    }

    public void onealMove() {
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

    public void killOneal() {
        this.setImg(Sprite.movingSprite(Sprite.oneal_dead, Sprite.mob_dead1, Sprite.mob_dead2, Sprite.mob_dead3, countOnealDead, decayTimer * 4 / 3).getFxImage());
        countOnealDead++;
        if (countOnealDead > decayTimer * 4 / 3) {
            for (int i = 0; i < enemy.size(); i++) {
                if (enemy.get(i).getX() == this.getX() && enemy.get(i).getY() == this.getY()) {
                    enemy.remove(i);
                }
            }
        }
    }

    @Override
    public void update() {
        onealMove();
        checkAlive();
        if (!life) {
            killOneal();
        }
    }
}
