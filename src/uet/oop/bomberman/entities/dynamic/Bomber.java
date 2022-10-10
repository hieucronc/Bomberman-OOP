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
import javafx.util.Duration;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;
import static uet.oop.bomberman.BombermanGame.*;
import java.awt.event.ActionEvent;

public class Bomber extends DynamicEntities {
    public Bomber(int x, int y, Image img) {
        super( x, y, img);
    }
    public void checkEnemy() {
        int ax = this.getX() ;
        int ay = this.getY() ;
        for (int i=0;i<enemy.size();i++) {
            int bx = enemy.get(i).getX() ;
            int by = enemy.get(i).getY() ;

            if (ax < bx + 32 &&
                    ax + 32 > bx &&
                    ay < by + 32 &&
                    ay + 32 > by ) {
                this.life = false;
                break;
            }
        }
    }
    public void checkBom() {

    }
    public void killBomber() {
        this.setImg(Sprite.movingSprite(Sprite.player_dead1,Sprite.player_dead2,Sprite.player_dead3,this.getY(),100).getFxImage());

    }
    @Override
    public void update() {
        checkBom();
        checkEnemy();
        if (this.life == false) {
            killBomber();
        }
    }
}
