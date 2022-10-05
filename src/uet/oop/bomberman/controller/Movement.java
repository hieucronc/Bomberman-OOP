package uet.oop.bomberman.controller;

import uet.oop.bomberman.entities.dynamic.*;

import static uet.oop.bomberman.BombermanGame.*;

import javafx.scene.input.KeyEvent;
import uet.oop.bomberman.graphics.Sprite;

public class Movement {
    public static final int BomberStep = 3;
    public static int Steptimer = 54;

    public static boolean canMoveDown(DynamicEntities dynamicEntities) {
        int x = dynamicEntities.getX() / 32;
        int y = dynamicEntities.getY() / 32;
        return position[x][y + 1] == 0;
    }

    public static boolean canMoveUp(DynamicEntities dynamicEntities) {
        int x = dynamicEntities.getX() / 32;
        int y = dynamicEntities.getY() / 32;
        return position[x][y - 1] == 0;
    }

    public static boolean canMoveLeft(DynamicEntities dynamicEntities) {
        int x = dynamicEntities.getX() / 32;
        int y = dynamicEntities.getY() / 32;
        return position[x - 1][y] == 0;
    }

    public static boolean canMoveRight(DynamicEntities dynamicEntities) {
        int x = dynamicEntities.getX() / 32;
        int y = dynamicEntities.getY() / 32;
        return position[x + 1][y] == 0;
    }

    public static void moveUp(DynamicEntities dynamicEntities) {

        if (canMoveUp(dynamicEntities) == true) {
            dynamicEntities.setImg(Sprite.movingSprite(Sprite.player_up, Sprite.player_up_1,
                    Sprite.player_up_2, dynamicEntities.getY(), Steptimer).getFxImage());
            dynamicEntities.setY(dynamicEntities.getY() - BomberStep);
        }

    }


    public static void moveDown(DynamicEntities dynamicEntities) {

        if (canMoveDown(dynamicEntities) == true) {
            dynamicEntities.setImg(Sprite.movingSprite(Sprite.player_down, Sprite.player_down_1,
                    Sprite.player_down_2, dynamicEntities.getY(), Steptimer).getFxImage());
            dynamicEntities.setY(dynamicEntities.getY() + BomberStep);
        }
    }


    public static void moveLeft(DynamicEntities dynamicEntities) {

        if (canMoveLeft(dynamicEntities) == true) {
            dynamicEntities.setImg(Sprite.movingSprite(Sprite.player_left, Sprite.player_left_1,
                    Sprite.player_left_2, dynamicEntities.getX(), Steptimer).getFxImage());
            dynamicEntities.setX(dynamicEntities.getX() - BomberStep);
        }
    }


    public static void moveRight(DynamicEntities dynamicEntities) {

        if (canMoveRight(dynamicEntities) == true) {
            dynamicEntities.setImg(Sprite.movingSprite(Sprite.player_right, Sprite.player_right_1,
                    Sprite.player_right_2, dynamicEntities.getX(), Steptimer).getFxImage());
            dynamicEntities.setX(dynamicEntities.getX() + BomberStep);
        }

    }


}
