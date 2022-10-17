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
import uet.oop.bomberman.entities.blocks.*;
import uet.oop.bomberman.entities.dynamic.Ballom;
import uet.oop.bomberman.entities.dynamic.Bomber;
import uet.oop.bomberman.entities.dynamic.DynamicEntities;
import uet.oop.bomberman.controller.Movement;
import uet.oop.bomberman.entities.items.BombItem;
import uet.oop.bomberman.entities.items.FlameItem;
import uet.oop.bomberman.entities.items.Portal;
import uet.oop.bomberman.entities.items.SpeedItem;
import uet.oop.bomberman.graphics.Sprite;

import java.io.File;
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

    public static final int WIDTH = 20;
    public static final int HEIGHT = 15;

    public static GraphicsContext gc;
    private Canvas canvas;
    public static List<Entity> entities = new ArrayList<>(); //gom nhan vat, grass
    public static List<Entity> block = new ArrayList<>(); // gom gach,tuong
    public static List<Entity> flame = new ArrayList<>();
    public static List<Entity> items = new ArrayList<>();
    public static List<Entity> bombs = new ArrayList<>();
    public static List<Entity> enemy = new ArrayList<>();
    public static int[][] position = new int[WIDTH][HEIGHT];

    public static DynamicEntities bomberman;

    public static void main(String[] args) throws Exception {
        Application.launch(BombermanGame.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
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
                    case W:
                        Movement.keyup = true;
                        break;
                    case DOWN:
                    case S:
                        Movement.keydown = true;
                        break;
                    case LEFT:
                    case A:
                        Movement.keyleft = true;
                        break;
                    case RIGHT:
                    case D:
                        Movement.keyright = true;
                        break;
                    case SPACE:
                        Bomb.placeBomb();

                    default:
                        break;
                }

            }
        });
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                switch (keyEvent.getCode()) {
                    case UP:
                    case W:
                        Movement.keyup = false;
                        break;
                    case DOWN:
                    case S:
                        Movement.keydown = false;
                        break;
                    case LEFT:
                    case A:
                        Movement.keyleft = false;
                        break;
                    case RIGHT:
                    case D:
                        Movement.keyright = false;
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


        bomberman = new Bomber(1, 1, Sprite.player_right.getFxImage());
        DynamicEntities ballom = new Ballom(3, 8, Sprite.balloom_left3.getFxImage());
        DynamicEntities ballom1 = new Ballom(5, 8, Sprite.balloom_left3.getFxImage());
        DynamicEntities ballom2 = new Ballom(7, 8, Sprite.balloom_left3.getFxImage());
        enemy.add(ballom);
        enemy.add(ballom1);
        enemy.add(ballom2);
        entities.add(bomberman);
    }
    public void createMap() throws Exception {
        System.out.println(System.getProperty("user.dir") + "/res/levels/lv1.txt");
        File file = new File(System.getProperty("user.dir") + "/res/levels/lv1.txt");

        Scanner scanner = new Scanner(file);
        int height = scanner.nextInt();
        int width = scanner.nextInt();
        scanner.nextLine();
        char[][] map = new char[height][width];
        for (int i = 0; i < height; i++) {
            String s = scanner.nextLine();
            for (int j = 0; j < width; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Entity baseobject = new Grass(j, i, Sprite.grass.getFxImage());
                position[j][i] = 0;
                entities.add(baseobject);
                if (Character.compare(map[i][j], '#') == 0) {
                    Entity object = new Wall(j, i, Sprite.wall.getFxImage());
                    position[j][i] = 1;
                    block.add(object);
                } else if (Character.compare(map[i][j], '*') == 0) {
                    Entity object = new Brick(j, i, Sprite.brick.getFxImage());
                    position[j][i] = 2;
                    block.add(object);
                } else if (Character.compare(map[i][j], 's') == 0) {
                    Entity object = new SpeedItem(j, i, Sprite.brick.getFxImage());
                    items.add(object);
                    block.add(object);
                } else if (Character.compare(map[i][j], 'b') == 0) {
                    Entity object = new BombItem(j, i, Sprite.brick.getFxImage());
                    items.add(object);
                    block.add(object);
                } else if (Character.compare(map[i][j], 'f') == 0) {
                    Entity object = new FlameItem(j, i, Sprite.brick.getFxImage());
                    items.add(object);
                    block.add(object);
                } else if (Character.compare(map[i][j], 'x') == 0) {
                    Entity object = new Portal(j, i, Sprite.brick.getFxImage());
                    items.add(object);
                    block.add(object);
                }
//                else {
//                    object = new Grass(j, i, Sprite.grass.getFxImage());
//                    position[j][i] = 0;
//                    entities.add(object);
//                }

            }
        }

    }

    public void update() {
        for (Entity entity : entities) {
            entity.update();
        }
        for (Entity entity : bombs) {
            entity.update();
        }
        for (Entity entity : enemy) {
            entity.update();
        }
        for (Entity entity : block) {
            entity.update();
        }
        for (Entity entity : items) {
            entity.update();
        }
    }

    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        entities.forEach(g -> g.render(gc));
        block.forEach(g -> g.render(gc));
        bombs.forEach(g -> g.render(gc));
        flame.forEach(g -> g.render(gc));
        enemy.forEach(g -> g.render(gc));
        items.forEach(g -> g.render(gc));
    }
}
