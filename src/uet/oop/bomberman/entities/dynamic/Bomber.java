package uet.oop.bomberman.entities.dynamic;

import javafx.scene.image.Image;
import uet.oop.bomberman.controller.Movement;
import static uet.oop.bomberman.controller.Movement.*;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.entities.items.FlamePassItem.*;

public class Bomber extends DynamicEntities {
    public static int bomberStep = 2;
    public Bomber(int x, int y, Image img) {
        super(x, y, img);
    }

    public void checkEnemy() {
        for (Entity entity : enemy) {
            if (Movement.collision(this, this.getX(), this.getY(), entity.getX(), entity.getY())) {
                this.life = false;
                break;
            }
        }
    }
    public void killBomber() {
        this.setImg(Sprite.movingSprite(Sprite.player_dead1, Sprite.player_dead2,
                Sprite.player_dead3, frameCount, 100).getFxImage());
        updateFrameCount();
        gc.drawImage(img, x, y);
    }
    public void updateMove() {
        if (keyup) {
            moveUp(this);
        }
        if (keydown) {
            moveDown(this);
        }
        if (keyleft) {
            moveLeft(this);
        }
        if (keyright) {
            moveRight(this);
        }
    }

    @Override
    public void update() {
        updateMove();
        if (!takeFlamePass) {
            checkAlive();
        }

        checkEnemy();
        if (!this.life) {
            killBomber();
        }
    }
}
