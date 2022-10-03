package uet.oop.bomberman;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import uet.oop.bomberman.entities.*;
import uet.oop.bomberman.entities.blocks.Grass;
import uet.oop.bomberman.entities.blocks.Wall;
import uet.oop.bomberman.entities.dynamic.Bomber;
import uet.oop.bomberman.entities.dynamic.DynamicEntities;
import uet.oop.bomberman.controller.Movement;
import uet.oop.bomberman.graphics.Sprite;

import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Scanner;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class BombermanGame extends Application {
    
    public static final int WIDTH = 30;
    public static final int HEIGHT = 20;
    
    private GraphicsContext gc;
    private Canvas canvas;
    private List<Entity> entities = new ArrayList<>();
    private List<Entity> stillObjects = new ArrayList<>();

    public static DynamicEntities bomberman;

    public static void main(String[] args) throws Exception {
        Application.launch(BombermanGame.class);
    }

    @Override
    public void start(Stage stage) throws  Exception{
        // Tao Canvas
        canvas = new Canvas(Sprite.SCALED_SIZE * WIDTH, Sprite.SCALED_SIZE * HEIGHT);
        gc = canvas.getGraphicsContext2D();

        // Tao root container
        Group root = new Group();
        root.getChildren().add(canvas);

        // Tao scene
        Scene scene = new Scene(root);
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                switch (keyEvent.getCode()) {
                    case UP:
                        Movement.moveUp(bomberman);

                        break;
                    case DOWN:
                        Movement.moveDown(bomberman);
                        break;
                    case LEFT:
                        Movement.moveLeft(bomberman);
                        break;
                    case RIGHT:
                        Movement.moveRight(bomberman);
                        break;
                    default:
                        break;
                }

            }
        });
        // Them scene vao stage
        stage.setScene(scene);
        stage.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                render();
                update();
            }
        };
        timer.start();

        createMap();

        bomberman = new Bomber(10, 10, Sprite.player_right.getFxImage());



        entities.add(bomberman);
    }
    //doc map tu file txt
    public List<String> loadMap() throws FileNotFoundException {

        String url = "G:/Backup/HK1/bombermanFull/res/levels/lv1.txt";

        FileInputStream fileInputStream = new FileInputStream(url);
        Scanner scanner = new Scanner(fileInputStream);
        List<String> map = new ArrayList<>();
        try {
            while (scanner.hasNextLine()) {
                map.add(scanner.nextLine());
            }
        } finally {
            try {
                scanner.close();
                fileInputStream.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return map;
    }
    //tao map
    public void createMap() throws Exception{
//        List<String> map = loadMap();
//
//
//        for (int i=0;i< map.size();i++) {
//            for (int j=0;j < map.get(0).length();j++) {
//                System.out.print(map.get(i).charAt(j));
//            }
//            System.out.println();
//        }
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                Entity object;
                if (j == 0 || j == HEIGHT - 1 || i == 0 || i == WIDTH - 1) {
                    object = new Wall(i, j, Sprite.wall.getFxImage());
                }
                else {
                    object = new Grass(i, j, Sprite.grass.getFxImage());
                }
                stillObjects.add(object);
            }
        }

    }

    public void update() {
        for (int i = 0; i < entities.size(); i++) {
            entities.get(i).update();
        }
//        entities.forEach(Entity::update);
    }

    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        stillObjects.forEach(g -> g.render(gc));
        entities.forEach(g -> g.render(gc));
    }
}
