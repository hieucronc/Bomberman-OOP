package uet.oop.bomberman.entities.dynamic;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import uet.oop.bomberman.controller.Movement;
import static uet.oop.bomberman.controller.Movement.*;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.*;

import uet.oop.bomberman.BombermanGame;

import java.awt.event.ActionEvent;

public class Bomber extends DynamicEntities {
    public static int bomberStep = 2;
    public Bomber(int x, int y, Image img) {
        super(x, y, img);
    }

    public void checkEnemy() {
        for (Entity entity : enemy) {
            if (Movement.collision(this.getX(), this.getY(), entity.getX(), entity.getY())) {
                this.life = false;
                break;
            }
        }
    }
    public void killBomber() {
        this.setImg(Sprite.movingSprite(Sprite.player_dead1, Sprite.player_dead2, Sprite.player_dead3, frameCount, 100).getFxImage());
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
        checkBomb();
        checkEnemy();
        if (!this.life) {
            killBomber();
        }
    }
}
