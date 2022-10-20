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
import uet.oop.bomberman.entities.dynamic.*;
import uet.oop.bomberman.controller.Movement;
import uet.oop.bomberman.entities.items.*;
import uet.oop.bomberman.graphics.Sprite;

import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.FileInputStream;

import java.io.IOException;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class BombermanGame extends Application {
    public static int level = 1;
    public static final int WIDTH = 31;
    public static final int HEIGHT = 13;

    public static GraphicsContext gc;
    private Canvas canvas;
    public static List<Entity> entities = new ArrayList<>(); //gom nhan vat, grass
    public static List<Entity> block = new ArrayList<>(); // gom gach,tuong
    public static Queue<Flame> flame = new LinkedList<>();
    public static List<Entity> items = new ArrayList<>();
    public static List<Entity> bombs = new ArrayList<>();
    public static List<Entity> enemy = new ArrayList<>();
    public static int[][] position = new int[HEIGHT][WIDTH];

    public static DynamicEntities bomberman;
    boolean pausing = false;

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
                        break;
                    case ESCAPE:
                        if (pausing) pausing = false;
                        else pausing = true;
                        break;
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
                try {
                    update();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        };
        timer.start();

        createMap();

    }

    public static void reset() {
        entities.clear();
        items.clear();
        block.clear();
        enemy.clear();
        flame.clear();
        bombs.clear();
        Flame.flameLength = 1;
    }

    public static void createMap() throws Exception {
        File file = new File(System.getProperty("user.dir") + "/res/levels/level" + level + ".txt");
//        File file = new File(System.getProperty("user.dir") + "/res/levels/testOneal.txt");
        reset();
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
                position[i][j] = 0;
                entities.add(baseobject);
                if (Character.compare(map[i][j], '#') == 0) {
                    Entity object = new Wall(j, i, Sprite.wall.getFxImage());
                    position[i][j] = 1;
                    block.add(object);
                } else if (Character.compare(map[i][j], '*') == 0) {
                    Entity object = new Brick(j, i, Sprite.brick.getFxImage());
                    position[i][j] = 2;
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
                } else if (Character.compare(map[i][j], 't') == 0) {
                    Entity object = new BombPassItem(j, i, Sprite.brick.getFxImage());
                    items.add(object);
                    block.add(object);
                } else if (Character.compare(map[i][j], 'y') == 0) {
                    Entity object = new FlamePassItem(j, i, Sprite.brick.getFxImage());
                    items.add(object);
                    block.add(object);
                } else if (Character.compare(map[i][j], 'x') == 0) {
                    Entity object = new Portal(j, i, Sprite.brick.getFxImage());
                    items.add(object);
                    block.add(object);
                } else if (Character.compare(map[i][j], '1') == 0) {
                    DynamicEntities ballom = new Ballom(j, i, Sprite.balloom_right1.getFxImage());
                    enemy.add(ballom);
                } else if (Character.compare(map[i][j], '2') == 0) {
                    DynamicEntities oneal = new Oneal(j, i, Sprite.oneal_right1.getFxImage());
                    enemy.add(oneal);
                } else if (Character.compare(map[i][j], '3') == 0) {
                    DynamicEntities doll = new Doll(j, i, Sprite.doll_right1.getFxImage());
                    enemy.add(doll);
                } else if (Character.compare(map[i][j], '4') == 0) {
                    DynamicEntities kondoria = new Kondoria(j, i, Sprite.kondoria_right1.getFxImage());
                    enemy.add(kondoria);
                } else if (Character.compare(map[i][j], '5') == 0) {
                    DynamicEntities minvo = new Minvo(j, i, Sprite.minvo_right1.getFxImage());
                    enemy.add(minvo);
                } else if (Character.compare(map[i][j], 'p') == 0) {
                    bomberman = new Bomber(j, i, Sprite.player_right.getFxImage());
                }
            }

        }
        entities.add(bomberman);
    }

    public void update() throws Exception {
        if (!pausing){
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
    }

    public void render() {
        if (!pausing) {
            gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            entities.forEach(g -> g.render(gc));
            block.forEach(g -> g.render(gc));
            bombs.forEach(g -> g.render(gc));
            flame.forEach(g -> g.render(gc));
            enemy.forEach(g -> g.render(gc));
            items.forEach(g -> g.render(gc));
        }
    }
}
