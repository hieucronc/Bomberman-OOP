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

import static uet.oop.bomberman.BombermanGame.pausing;
import static uet.oop.bomberman.BombermanGame.running;

public class Menu {
    public static Text level, bomb, time;
    public static ImageView statusGame, newGameButton, exitButton, backgroundMenu;
    public static Image resumeGame, pauseGame;
    public static int bomb_number = 20, time_number = 120;

    //    public static Pane pane;
    static Image newGameImage = new Image("file:res/textures/start.png");
//    static Image exitGameImage = new Image("file:src/main/resources/levels/exit.png");

    public static void createMenu(Group root) {

        if (!running) {
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

//        level = new Text("Level: 1");
//        level.setFont(Font.font("Arial", FontWeight.BOLD, 14));
//        level.setFill(Color.WHITE);
//        level.setX(416);
//        level.setY(20);

//        bomb = new Text("Bombs: " + bomb_number);
//        bomb.setFont(Font.font("Arial", FontWeight.BOLD, 14));
//        bomb.setFill(Color.WHITE);
//        bomb.setX(512);
//        bomb.setY(20);

//        time = new Text("Times: " + time_number);
//        time.setFont(Font.font("Arial", FontWeight.BOLD, 14));
//        time.setFill(Color.WHITE);
//        time.setX(608);
//        time.setY(20);

//        resumeGame = new Image("file:src/main/resources/levels/pause.png");
//        pauseGame = new Image("file:src/main/resources/levels/resume.png");
//        statusGame = new ImageView(resumeGame);
//        statusGame.setX(5);
//        statusGame.setY(3);

//        pane = new Pane();
//        pane.getChildren().addAll(level, bomb, time, statusGame);
//        pane.setTranslateY(480);
//        pane.setMinSize(800, 32);
//        pane.setMaxSize(800, 480);
//        pane.setStyle("-fx-background-color: #000000");


        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                newGameButton.setOnMouseClicked(event -> {
                    running = true;
                    backgroundMenu.setVisible(false);
                    newGameButton.setVisible(false);
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

    public static void gameOver(Group root) {
//        Image gameOverBackground = new Image("file:src/main/resources/levels/game_over.jpg");
//        backgroundMenu.setImage(gameOverBackground);
//        pane.setVisible(false);
//        title_screen.close();

        newGameButton.setImage(newGameImage);
        newGameButton.setX(230);
        newGameButton.setY(330);
        newGameButton.setScaleX(0.1);
        newGameButton.setScaleY(0.1);

//        exitButton.setImage(exitGameImage);
//        exitButton.setX(230);
//        exitButton.setY(390);
//        exitButton.setScaleX(0.4);
//        exitButton.setScaleY(0.4);
        running = false;
        AnimationTimer timer2 = new AnimationTimer() {
            @Override
            public void handle(long l) {
                newGameButton.setOnMouseClicked(event -> {
                    backgroundMenu.setVisible(false);
                    newGameButton.setVisible(false);
//                    exitButton.setVisible(false);
//                    pane.setVisible(true);
                });
//                exitButton.setOnMouseClicked(event -> {
//                    Platform.exit();
//
//                });
            }
        };
        timer2.start();
    }
//    public static void updateMenu() {
//        if (pausing) {
//            statusGame.setImage(pauseGame);
//        } else {
//            statusGame.setImage(resumeGame);
//        }
}
//}
