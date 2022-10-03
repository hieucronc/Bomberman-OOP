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

import java.awt.event.ActionEvent;

public class Bomber extends DynamicEntities {

    public Bomber(int x, int y, Image img) {
        super( x, y, img);
    }

//    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.5), event -> {
//        if(number == 1){
//            charactor.setImage(Sprite.player_up.getFxImage());
//            number = 2;
//        } else if( number == 2){
//            charactor.setImage(Sprite.player_up_1.getFxImage());
//            number = 3;
//        } else if (number == 3){
//            charactor.setImage(Sprite.player_up_2.getFxImage());
//            number = 1;
//        }
//    }));
//
//    public Bomber(int x, int y, Image img,ImageView charactor) {
//        super( x, y, img);
//        this.charactor = charactor;
//        timeline.setCycleCount(Animation.INDEFINITE);
//    }
//
//    public void startAnimation(){
//        timeline.play();
//    }
//
//    public void stopAnimation(){
//        timeline.stop();
//    }

    @Override
    public void update() {

    }
}
