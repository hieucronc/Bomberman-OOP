package uet.oop.bomberman;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import uet.oop.bomberman.controller.Movement;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.blocks.*;
import uet.oop.bomberman.entities.dynamic.*;
import uet.oop.bomberman.entities.items.*;
import uet.oop.bomberman.graphics.Sprite;
import java.io.File;
import java.util.*;

import static bomberman.control.Menu.createMenu;
import static uet.oop.bomberman.sound.SoundManager.*;
public class BombermanGame extends Application {
    public static int level = 1;
    public static final int WIDTH = 31;
    public static final int HEIGHT = 13;

    public static GraphicsContext gc;
    public static boolean pausing = false;
    public static boolean running = false;
    private Canvas canvas;
    public boolean cnt = true;
    public static List<Entity> entities = new ArrayList<>(); //gom nhan vat, grass
    public static List<Entity> block = new ArrayList<>(); // gom gach,tuong
    public static Queue<Flame> flame = new LinkedList<>();
    public static List<Entity> items = new ArrayList<>();
    public static List<Entity> bombs = new ArrayList<>();
    public static List<Entity> enemy = new ArrayList<>();
    public static int[][] position = new int[HEIGHT][WIDTH];

    public static DynamicEntities bomberman;
    public boolean started = false;


    public static void main(String[] args) {
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
        createMenu(root);
        // Tao scene
        Scene scene = new Scene(root);
        scene.setOnKeyPressed(keyEvent -> {
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
                    pausing = !pausing;
                    break;
                default:
                    break;
            }

        });
        scene.setOnKeyReleased(keyEvent -> {
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
        });
        if (cnt) {
            titleScreen();
            cnt = false;
        }
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
//        File file = new File(System.getProperty("user.dir") + "/res/levels/level4.txt");
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
                if (map[i][j] == '#') {
                    Entity object = new Wall(j, i, Sprite.wall.getFxImage());
                    position[i][j] = 1;
                    block.add(object);
                } else if (map[i][j] == '*') {
                    Entity object = new Brick(j, i, Sprite.brick.getFxImage());
                    position[i][j] = 2;
                    block.add(object);
                } else if (map[i][j] == 's') {
                    Entity object = new SpeedItem(j, i, Sprite.brick.getFxImage());
                    items.add(object);
                    block.add(object);
                    position[i][j] = 2;
                } else if (map[i][j] == 'b') {
                    Entity object = new DestroyItem(j, i, Sprite.brick.getFxImage());
                    items.add(object);
                    block.add(object);
                    position[i][j] = 2;
                } else if (map[i][j] == 'r') {
                    Entity object = new RandomItem(j, i, Sprite.brick.getFxImage());
                    items.add(object);
                    block.add(object);
                    position[i][j] = 2;
                } else if (map[i][j] == 'f') {
                    Entity object = new FlameItem(j, i, Sprite.brick.getFxImage());
                    items.add(object);
                    block.add(object);
                    position[i][j] = 2;
                } else if (map[i][j] == 't') {
                    Entity object = new BombPassItem(j, i, Sprite.brick.getFxImage());
                    items.add(object);
                    block.add(object);
                    position[i][j] = 2;
                } else if (map[i][j] == 'y') {
                    Entity object = new FlamePassItem(j, i, Sprite.brick.getFxImage());
                    items.add(object);
                    block.add(object);
                    position[i][j] = 2;
                } else if (map[i][j] == 'x') {
                    Entity object = new Portal(j, i, Sprite.brick.getFxImage());
                    items.add(object);
                    block.add(object);
                    position[i][j] = 2;
                } else if (map[i][j] == 'e') {
                    Entity object = new SpeedEnemy(j, i, Sprite.brick.getFxImage());
                    items.add(object);
                    block.add(object);
                    position[i][j] = 2;
                } else if (map[i][j] == 'v') {
                    Entity object = new CounterSpeed(j, i, Sprite.brick.getFxImage());
                    items.add(object);
                    block.add(object);
                    position[i][j] = 2;
                } else if (map[i][j] == '1') {
                    Enemy ballom = new Ballom(j, i, Sprite.balloom_right1.getFxImage());
                    enemy.add(ballom);
                } else if (map[i][j] == '2') {
                    Enemy oneal = new Oneal(j, i, Sprite.oneal_right1.getFxImage());
                    enemy.add(oneal);
                } else if (map[i][j] == '3') {
                    Enemy doll = new Doll(j, i, Sprite.doll_right1.getFxImage());
                    enemy.add(doll);
                } else if (map[i][j] == '4') {
                    Enemy kondoria = new Kondoria(j, i, Sprite.kondoria_right1.getFxImage());
                    enemy.add(kondoria);
                } else if (map[i][j] == '5') {
                    Enemy minvo = new Minvo(j, i, Sprite.minvo_right1.getFxImage());
                    enemy.add(minvo);
                } else if (map[i][j] == '6') {
                    Enemy superOneal = new SuperOneal(j, i, Sprite.super_oneal_right1.getFxImage());
                    enemy.add(superOneal);
                } else if (map[i][j] == '7') {
                    Enemy statue = new Statue(j, i, Sprite.brick.getFxImage());
                    block.add(statue);
                    enemy.add(statue);
                    position[i][j] = 2;
                } else if (map[i][j] == '8') {
                    Enemy ghost = new Ghost(j, i, Sprite.ghost_right1.getFxImage());
                    enemy.add(ghost);
                } else if (map[i][j] == 'p') {
                    bomberman = new Bomber(j, i, Sprite.player_right.getFxImage());
                }
            }

        }
        entities.add(bomberman);
    }

    public void update() throws Exception {
        if (!pausing) {
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
            items.forEach(g -> g.render(gc));
            enemy.forEach(g -> g.render(gc));
//            bomberman.render(gc);
        }
    }
}
