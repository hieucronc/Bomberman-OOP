package uet.oop.bomberman.controller;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import uet.oop.bomberman.BombermanGame;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

import static uet.oop.bomberman.BombermanGame.running;
import static uet.oop.bomberman.sound.SoundManager.buttonSound;
import static uet.oop.bomberman.sound.SoundManager.titleScreen;

public class Menu {
    public static ImageView backButton, newGameButton, exitButton, backgroundMenu, instruction;
    public static ImageView itemPage, itemButton, monsterButton, howButton;
    public static ImageView enemyPage;
    //    public static Pane pane;
    static Image backgroundMenuImage = new Image("file:res/textures/Name.png");
    static Image exitGameImage = new Image("file:res/textures/exit.png");
    static Image itemImage = new Image("file:res/textures/itempage.png");
    static Image enemyImage = new Image("file:res/textures/enemypage.png");
    static Image backImage = new Image("file:res/textures/back.png");
    static Image newGameImage = new Image("file:res/textures/start.png");
    static Image enemyButtonImage = new Image("file:res/textures/monsterbutton.png");
    static Image itembuttonImage = new Image("file:res/textures/itembutton.png");
    static Image howbuttonImage = new Image("file:res/textures/howButton.png");
    static Image howImage = new Image("file:res/textures/instructionpage.png");


    public static void createMenu(Group root) throws UnsupportedAudioFileException, LineUnavailableException, IOException {

        if (!running) {
            titleScreen();
            backgroundMenu = new ImageView(backgroundMenuImage);
            backgroundMenu.setX(0);
            backgroundMenu.setY(0);

            exitButton = new ImageView(exitGameImage);
            newGameButton = new ImageView(newGameImage);
            backButton = new ImageView(backImage);
            enemyPage = new ImageView(enemyImage);
            itemPage = new ImageView(itemImage);
            itemButton = new ImageView(itembuttonImage);
            monsterButton = new ImageView(enemyButtonImage);
            howButton = new ImageView(howbuttonImage);
            instruction = new ImageView(howImage);

            newGameButton.setX(320);
            newGameButton.setY(250);
            newGameButton.setScaleX(0.5);
            newGameButton.setScaleY(0.5);

            exitButton.setX(890);
            exitButton.setY(305);
            exitButton.setScaleX(0.2);
            exitButton.setScaleY(0.2);

            backButton.setX(855);
            backButton.setY(-75);
            backButton.setScaleX(0.2);
            backButton.setScaleY(0.2);

            itemButton.setX(801);
            itemButton.setY(70);

            monsterButton.setX(804);
            monsterButton.setY(178);

            howButton.setX(25);
            howButton.setY(122);

            root.getChildren().add(backgroundMenu);
            root.getChildren().add(newGameButton);
            root.getChildren().add(exitButton);
            root.getChildren().add(monsterButton);
            root.getChildren().add(itemButton);
            root.getChildren().add(enemyPage);
            root.getChildren().add(itemPage);
            root.getChildren().add(instruction);
            root.getChildren().add(backButton);
            root.getChildren().add(howButton);
            displayMenu();
        }


        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                newGameButton.setOnMouseClicked(event -> {
                    running = true;
                    backgroundMenu.setVisible(false);
                    exitButton.setVisible(false);
                    monsterButton.setVisible(false);
                    itemButton.setVisible(false);
                    newGameButton.setVisible(false);
                    howButton.setVisible(false);
                    playButtonSound();

                    try {
                        BombermanGame.createMap();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
                exitButton.setOnMouseClicked(event -> Platform.exit());
                backButton.setOnMouseClicked(event -> {
                    displayMenu();
                    playButtonSound();
                });
                itemButton.setOnMouseClicked(event -> {
                    displayItem();
                    playButtonSound();
                });
                monsterButton.setOnMouseClicked(event -> {
                    displayMonster();
                    playButtonSound();
                });
                howButton.setOnMouseClicked(event -> {
                    displayInstruction();
                    playButtonSound();
                });

            }
        };
        timer.start();
    }

    public static void playButtonSound() {
        try {
            buttonSound();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }

    public static void displayMenu() {
        backgroundMenu.setVisible(true);
        exitButton.setVisible(true);
        monsterButton.setVisible(true);
        itemButton.setVisible(true);
        newGameButton.setVisible(true);
        itemPage.setVisible(false);
        enemyPage.setVisible(false);
        backButton.setVisible(false);
        instruction.setVisible(false);
        howButton.setVisible(true);
    }

    public static void displayItem() {
        backgroundMenu.setVisible(false);
        exitButton.setVisible(false);
        monsterButton.setVisible(false);
        itemButton.setVisible(false);
        newGameButton.setVisible(false);
        itemPage.setVisible(true);
        instruction.setVisible(false);
        enemyPage.setVisible(false);
        backButton.setVisible(true);
        howButton.setVisible(false);
    }

    public static void displayMonster() {
        backgroundMenu.setVisible(false);
        exitButton.setVisible(false);
        monsterButton.setVisible(false);
        itemButton.setVisible(false);
        newGameButton.setVisible(false);
        itemPage.setVisible(false);
        instruction.setVisible(false);
        howButton.setVisible(false);
        enemyPage.setVisible(true);
        backButton.setVisible(true);
    }
    public static void displayInstruction() {
        backgroundMenu.setVisible(false);
        exitButton.setVisible(false);
        monsterButton.setVisible(false);
        itemButton.setVisible(false);
        newGameButton.setVisible(false);
        itemPage.setVisible(false);
        enemyPage.setVisible(false);
        howButton.setVisible(false);
        backButton.setVisible(true);
        instruction.setVisible(true);
    }
}

