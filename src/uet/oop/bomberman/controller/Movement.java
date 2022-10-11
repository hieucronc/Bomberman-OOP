package uet.oop.bomberman.controller;
import uet.oop.bomberman.entities.dynamic.*;
import static uet.oop.bomberman.BombermanGame.*;
import javafx.scene.input.KeyEvent;
import uet.oop.bomberman.graphics.Sprite;

public class Movement {
    public static boolean canMoveDown(DynamicEntities dynamicEntities) {
        int x = dynamicEntities.getX() / 32;
        int y = (dynamicEntities.getY() ) / 32;
        return position[x][y+1] == 0;
    }
    public static boolean canMoveUp(DynamicEntities dynamicEntities) {
        int x = dynamicEntities.getX() / 32;
        int y = (dynamicEntities.getY() ) / 32;
        return position[x][y-1] == 0;
    }
    public static boolean canMoveLeft(DynamicEntities dynamicEntities) {
        int x = (dynamicEntities.getX() ) / 32;
        int y = dynamicEntities.getY() / 32;
        return position[x-1][y] == 0;
    }
    public static boolean canMoveRight(DynamicEntities dynamicEntities) {
        int x = (dynamicEntities.getX() ) / 32;
        int y = dynamicEntities.getY() / 32;
        return position[x+1][y] == 0;
    }

    public static void moveUp(DynamicEntities dynamicEntities) {
        if (dynamicEntities instanceof Bomber) {
            dynamicEntities.setImg(Sprite.movingSprite(Sprite.player_up,Sprite.player_up_1,Sprite.player_up_2,dynamicEntities.getY(),54).getFxImage());
            if (canMoveUp(dynamicEntities))  {
                dynamicEntities.setY(dynamicEntities.getY() - 3);
            }
        }
        if (dynamicEntities instanceof Ballom) {
            dynamicEntities.setImg(Sprite.movingSprite(Sprite.balloom_right1,Sprite.balloom_right2,Sprite.balloom_right3,dynamicEntities.getY(),100).getFxImage());
            if (canMoveDown(dynamicEntities)) {
                dynamicEntities.setY(dynamicEntities.getY() - 1);
            }
        }

    }

    public static void moveDown(DynamicEntities dynamicEntities) {
        if (dynamicEntities instanceof Bomber) {
            dynamicEntities.setImg(Sprite.movingSprite(Sprite.player_down,Sprite.player_down_1,Sprite.player_down_2,dynamicEntities.getY(),54).getFxImage());
            if (canMoveDown(dynamicEntities)) {
                dynamicEntities.setY(dynamicEntities.getY() + 3);
            }
        }
        if (dynamicEntities instanceof Ballom) {
            dynamicEntities.setImg(Sprite.movingSprite(Sprite.balloom_left1,Sprite.balloom_left2,Sprite.balloom_left3,dynamicEntities.getY(),100).getFxImage());
            if (canMoveDown(dynamicEntities)) {
                dynamicEntities.setY(dynamicEntities.getY() + 1);
            }
        }
    }
    public static void moveLeft(DynamicEntities dynamicEntities) {
        if (dynamicEntities instanceof Bomber) {
            dynamicEntities.setImg(Sprite.movingSprite(Sprite.player_left,Sprite.player_left_1,Sprite.player_left_2,dynamicEntities.getX(),54).getFxImage());
            if (canMoveLeft(dynamicEntities)) {
                dynamicEntities.setX(dynamicEntities.getX() - 4);
            }
        }
        if (dynamicEntities instanceof Ballom) {
            dynamicEntities.setImg(Sprite.movingSprite(Sprite.balloom_left1,Sprite.balloom_left2,Sprite.balloom_left3,dynamicEntities.getY(),100).getFxImage());
            if (canMoveDown(dynamicEntities)) {
                dynamicEntities.setX(dynamicEntities.getX() - 1);
            }
        }
    }


    public static void moveRight(DynamicEntities dynamicEntities) {
        if (dynamicEntities instanceof Bomber) {
            dynamicEntities.setImg(Sprite.movingSprite(Sprite.player_right,Sprite.player_right_1,Sprite.player_right_2,dynamicEntities.getX(),54).getFxImage());
            if (canMoveRight(dynamicEntities)) {
                dynamicEntities.setX(dynamicEntities.getX() + 4);
            }
        }
        if (dynamicEntities instanceof Ballom) {
            dynamicEntities.setImg(Sprite.movingSprite(Sprite.balloom_right1,Sprite.balloom_right2,Sprite.balloom_right3,dynamicEntities.getY(),100).getFxImage());
            if (canMoveDown(dynamicEntities)) {
                dynamicEntities.setX(dynamicEntities.getX() + 1);
            }
        }
    }


}

