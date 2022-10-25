package uet.oop.bomberman.entities.dynamic;
import javafx.scene.image.Image;
import uet.oop.bomberman.controller.Movement;
import uet.oop.bomberman.graphics.Sprite;

import java.util.Random;

import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.BombermanGame.enemy;
import static uet.oop.bomberman.entities.blocks.Bomb.decayTimer;

public class Statue extends Enemy{
    private int dir = DOWN;
    public static int statueStep = 1;
    private int countStatueDead = 0;
    public boolean alive = false;
    public Statue(int x, int y, Image image) {
        super(x,y,image);
    }
    public void killStatue() {
        this.setImg(Sprite.movingSprite(Sprite.statue_dead, Sprite.mob_dead1, Sprite.mob_dead2,
                Sprite.mob_dead3, countStatueDead, decayTimer * 4 / 3).getFxImage());
        countStatueDead++;
        if (countStatueDead > decayTimer * 4 / 3) {
            for (int i = 0; i < enemy.size(); i++) {
                if (enemy.get(i).getX() == this.getX() && enemy.get(i).getY() == this.getY()) {
                    enemy.remove(i);
                    break;
                }
            }
        }
    }
    public void statueMove() {
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
    @Override
    public void update() {
        if (!alive && checkBomb()) {
            for (int i=0;i<block.size();i++) {
                if (block.get(i) instanceof Statue) {
                    if (block.get(i).getY() == this.getY() && block.get(i).getX() == this.getX()) {
                        block.remove(i);
                        break;
                    }
                }
            }
            this.setImg(Sprite.statue_right1.getFxImage());
            alive = true;
            position[this.getY() / Sprite.SCALED_SIZE][this.getX() / Sprite.SCALED_SIZE] = 0;
        }
        if (alive) {
            statueMove();
        }
        if (alive && checkBomb()) {
            killStatue();
        }
    }
}
