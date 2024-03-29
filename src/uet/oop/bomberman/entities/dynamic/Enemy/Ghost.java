package uet.oop.bomberman.entities.dynamic.Enemy;

import javafx.scene.image.Image;
import uet.oop.bomberman.controller.Movement;
import uet.oop.bomberman.entities.dynamic.Smart.Vertex;
import uet.oop.bomberman.graphics.Sprite;

import java.util.Random;

import static uet.oop.bomberman.BombermanGame.bomberman;
import static uet.oop.bomberman.BombermanGame.enemy;
import static uet.oop.bomberman.entities.blocks.Bomb.decayTimer;
import static uet.oop.bomberman.entities.dynamic.Smart.Ai.*;

public class Ghost extends Enemy {
    public static int ghostStep = 2;
    private int countGhostDead = 0;
    private int dir = DOWN;

    public Ghost(int x, int y, Image img) {
        super(x, y, img);
    }

    public void ghostMove() {

        //tinh toan vi tri cua bomber
        double tmp1X = (double) bomberman.getX() / Sprite.SCALED_SIZE;
        int eX = (int) Math.round(tmp1X);
        double tmp1Y = (double) bomberman.getY() / Sprite.SCALED_SIZE;
        int eY = (int) Math.round(tmp1Y);
        Vertex e = new Vertex(eY, eX);

        //tinh toan vi tri cua super oneal
        double tmp2X = (double) this.getX() / Sprite.SCALED_SIZE;
        int sX = (int) Math.round(tmp2X);
        double tmp2Y = (double) this.getY() / Sprite.SCALED_SIZE;
        int sY = (int) Math.round(tmp2Y);
        Vertex s = new Vertex(sY, sX);
        bfsForGhost(s.x, s.y);
        if (connectedComponentGhost(s, e)) {
            path(s, e);
//            System.out.println("Duong di tu e den s");
//            for (int i = 0; i < parent.size(); i++) {
//                System.out.println(parent.get(i).x + " " + parent.get(i).y);
//            }
//            System.out.println("O tiep theo can di toi");
            if (parent.size() >= 1) {
                Vertex nextMove = parent.get(parent.size() - 1);
                if (nextMove.x * Sprite.SCALED_SIZE > this.getY()) {
                    Movement.moveDown(this);
                }
                if (nextMove.x * Sprite.SCALED_SIZE < this.getY()) {
                    Movement.moveUp(this);
                }
                if (nextMove.y * Sprite.SCALED_SIZE > this.getX()) {
                    Movement.moveRight(this);
                }
                if (nextMove.y * Sprite.SCALED_SIZE < this.getX()) {
                    Movement.moveLeft(this);
                }
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
        resetFindPath();

    }

    public void killGhost() {
        this.setImg(Sprite.movingSprite(Sprite.ghost_dead, Sprite.mob_dead1, Sprite.mob_dead2,
                Sprite.mob_dead3, countGhostDead, decayTimer * 4 / 3).getFxImage());
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
        if (life)
            ghostMove();
        checkAlive();
        if (!life) {
            killGhost();
        }
    }
}
