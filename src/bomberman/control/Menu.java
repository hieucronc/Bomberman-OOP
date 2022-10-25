package bomberman.control;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import uet.oop.bomberman.BombermanGame;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

import static uet.oop.bomberman.BombermanGame.pausing;
import static uet.oop.bomberman.BombermanGame.running;
import static uet.oop.bomberman.sound.SoundManager.buttonSound;
import static uet.oop.bomberman.sound.SoundManager.titleScreen;

public class Menu {
    public static Text level, bomb, time;
    public static ImageView statusGame, newGameButton, exitButton, backgroundMenu;
    public static Image resumeGame, pauseGame;
    public static int bomb_number = 20, time_number = 120;

    //    public static Pane pane;
    static Image newGameImage = new Image("file:res/textures/start.png");
//    static Image exitGameImage = new Image("file:src/main/resources/levels/exit.png");

    public static void createMenu(Group root) throws UnsupportedAudioFileException, LineUnavailableException, IOException {

        if (!running) {
            titleScreen();
            Image backgroundMenuImage = new Image("file:res/textures/Name.png");
            backgroundMenu = new ImageView(backgroundMenuImage);
            backgroundMenu.setX(0);
            backgroundMenu.setY(0);
//            backgroundMenu.setScaleX(0.05);
//            backgroundMenu.setScaleY(0.05);

//            exitButton = new ImageView(exitGameImage);
            newGameButton = new ImageView(newGameImage);

            newGameButton.setX(320);
            newGameButton.setY(250);
            newGameButton.setScaleX(0.5);
            newGameButton.setScaleY(0.5);

//            exitButton.setX(20);
//            exitButton.setY(300);
//            exitButton.setScaleX(0.5);
//            exitButton.setScaleY(0.5);
            root.getChildren().add(backgroundMenu);
            root.getChildren().add(newGameButton);
//            root.getChildren().add(exitButton);
        }



        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                newGameButton.setOnMouseClicked(event -> {
                    running = true;
                    backgroundMenu.setVisible(false);
                    newGameButton.setVisible(false);
                    try {
                        buttonSound();
                    } catch (UnsupportedAudioFileException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    } catch (LineUnavailableException e) {
                        throw new RuntimeException(e);
                    }

                    try {
                        BombermanGame.createMap();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
//                    exitButton.setVisible(false);
                });
//                exitButton.setOnMouseClicked(event -> {
//                    Platform.exit();
//                });
//                statusGame.setOnMouseClicked(event -> {
//                    pausing = !pausing;
//                    running = !running;
//                });
//                updateMenu();
            }
        };
        timer.start();
    }


}

