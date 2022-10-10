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
import uet.oop.bomberman.entities.dynamic.Ballom;
import uet.oop.bomberman.entities.dynamic.Bomber;
import uet.oop.bomberman.entities.blocks.Bomb;
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
    public static List<Entity> entities = new ArrayList<>();
    private List<Entity> block = new ArrayList<>();
    public static List<Entity> enemy = new ArrayList<>();
    public static int[][] position = new int [WIDTH][HEIGHT];

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
                    case SPACE:
                        Bomb.placeBomb();
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
        DynamicEntities ballom = new Ballom(3,1,Sprite.balloom_left3.getFxImage());
        enemy.add(ballom);
        entities.add(bomberman);
    }
    public void createMap() throws Exception{
        //String url = "../../res/levels/lv1.txt";
        String url = "G:/Backup/Bomberman_BTL/res/levels/lv1.txt";

        FileInputStream fileInputStream = new FileInputStream(url);
        Scanner scanner = new Scanner(fileInputStream);
        int height = scanner.nextInt();
        int width = scanner.nextInt();
        scanner.nextLine();
        char[][] map = new char[height][width];
        for (int i=0;i<height;i++) {
            String s = scanner.nextLine();
            for (int j=0;j<width;j++) {
                map[i][j] = s.charAt(j);
            }
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Entity object;
                if (Character.compare(map[i][j],'#') == 0) {
                    object = new Wall(j, i, Sprite.wall.getFxImage());
                    position[j][i] = 1;
                }
                else {
                    object = new Grass(j, i, Sprite.grass.getFxImage());
                }
                block.add(object);
            }
        }

    }

    public void update() {
        for (int i = 0; i < entities.size(); i++) {
            entities.get(i).update();
        }
        for (int i = 0; i < enemy.size();i++) {
            enemy.get(i).update();
        }
//        entities.forEach(Entity::update);
    }

    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        block.forEach(g -> g.render(gc));
        entities.forEach(g -> g.render(gc));
        enemy.forEach(g -> g.render(gc));
    }
}
