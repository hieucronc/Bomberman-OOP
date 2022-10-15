package uet.oop.bomberman.entities.dynamic;

import javafx.scene.image.Image;
import uet.oop.bomberman.controller.Movement;
import uet.oop.bomberman.graphics.Sprite;
import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.entities.blocks.Bomb.decayTimer;

import java.util.Random;

public class Ballom extends DynamicEntities {
    private int tick = 0;
    private int dir;
    int countBallomDead = 0;
    public Ballom(int x, int y, Image img) {
        super(x,y,img);
    }
    public void enemyMove() {
        Random random = new Random();

        if (tick % 70 == 0) {
            dir = random.nextInt(4);
        }
        switch (dir) {
            case 0:
                Movement.moveUp(this);
                break;
            case 1:
                Movement.moveDown(this);
                break;
            case 2:
                Movement.moveLeft(this);
                break;
            case 3:
                Movement.moveRight(this);
                break;

        }
    }

    public void killBallom() {
        this.setImg(Sprite.movingSprite(Sprite.balloom_dead,Sprite.balloom_dead,Sprite.balloom_dead,countBallomDead,60).getFxImage());
        countBallomDead++;
        if (countBallomDead > decayTimer)  {
            for (int i=0;i<enemy.size();i++) {
                if (enemy.get(i).getX() == this.getX() && enemy.get(i).getY() == this.getY()) {
                    enemy.remove(i);
                }
            }
        }
    }

    @Override
    public void update() {
        tick++;
        if (tick > 1e6) {
            tick = 0;
        }
        enemyMove();
        checkBomb();
        if (!life) {
            killBallom();
        }
    }
}
