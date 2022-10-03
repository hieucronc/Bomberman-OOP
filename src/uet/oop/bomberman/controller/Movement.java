package uet.oop.bomberman.controller;
import uet.oop.bomberman.entities.dynamic.*;
import javafx.scene.input.KeyEvent;
import uet.oop.bomberman.graphics.Sprite;

public class Movement {

    public static void checkRun(DynamicEntities dynamicEntities) {
        setDirection(dynamicEntities.getDirection(), dynamicEntities, 1);
        dynamicEntities.setCount(dynamicEntities.getCount() - 1);
    }

    private static void setDirection(int direction, DynamicEntities dynamicEntities, int isMove) {
        switch (direction) {
            case 1:  // down
                down_step(dynamicEntities);
                dynamicEntities.setY(dynamicEntities.getY() + isMove);
                break;
            case 2: // up
                up_step(dynamicEntities);
                dynamicEntities.setY(dynamicEntities.getY() - isMove);
                break;
            case 3: // left
                left_step(dynamicEntities);
                dynamicEntities.setX(dynamicEntities.getX() - isMove);
                break;
            case 4: // right
                right_step(dynamicEntities);
                dynamicEntities.setX(dynamicEntities.getX() + isMove);
                break;
        }
    }

    public static void moveUp(DynamicEntities dynamicEntities) {
//        dynamicEntities.setDirection(2);
//        dynamicEntities.setCount(4 / 1);
//        checkRun(dynamicEntities);

        if (dynamicEntities.getSwap() == 1) {
            dynamicEntities.setImg(Sprite.player_up.getFxImage());
            dynamicEntities.setSwap(2);
        } else if (dynamicEntities.getSwap() == 2) {
            dynamicEntities.setImg(Sprite.player_up_1.getFxImage());
            dynamicEntities.setSwap(3);
        } else if (dynamicEntities.getSwap() == 3) {
            dynamicEntities.setImg(Sprite.player_up.getFxImage());
            dynamicEntities.setSwap(4);
        } else {
            dynamicEntities.setImg(Sprite.player_up_2.getFxImage());
            dynamicEntities.setSwap(1);
        }
        dynamicEntities.setY(dynamicEntities.getY() - 16);
    }

    private static void up_step(DynamicEntities dynamicEntities) {
        if (dynamicEntities.getSwap() == 1) {
            dynamicEntities.setImg(Sprite.player_up.getFxImage());
            dynamicEntities.setSwap(2);
        } else if (dynamicEntities.getSwap() == 2) {
            dynamicEntities.setImg(Sprite.player_up_1.getFxImage());
            dynamicEntities.setSwap(3);
        } else if (dynamicEntities.getSwap() == 3) {
            dynamicEntities.setImg(Sprite.player_up.getFxImage());
            dynamicEntities.setSwap(4);
        } else {
            dynamicEntities.setImg(Sprite.player_up_2.getFxImage());
            dynamicEntities.setSwap(1);
        }
    }

    public static void moveDown(DynamicEntities dynamicEntities) {
//        dynamicEntities.setDirection(1);
//        dynamicEntities.setCount(4 / 1);
//        checkRun(dynamicEntities);

        if (dynamicEntities instanceof Bomber && dynamicEntities.getY() % 8 == 0) {
            if (dynamicEntities.getSwap() == 1) {
                dynamicEntities.setImg(Sprite.player_down.getFxImage());
                dynamicEntities.setSwap(2);
            } else if (dynamicEntities.getSwap() == 2) {
                dynamicEntities.setImg(Sprite.player_down_1.getFxImage());
                dynamicEntities.setSwap(3);
            } else if (dynamicEntities.getSwap() == 3) {
                dynamicEntities.setImg(Sprite.player_down.getFxImage());
                dynamicEntities.setSwap(4);
            } else {
                dynamicEntities.setImg(Sprite.player_down_2.getFxImage());
                dynamicEntities.setSwap(1);
            }
        }
        dynamicEntities.setY(dynamicEntities.getY() + 16);
    }
    private static void down_step(DynamicEntities dynamicEntities) {
        if (dynamicEntities.getSwap() == 1) {
            dynamicEntities.setImg(Sprite.player_down.getFxImage());
            dynamicEntities.setSwap(2);
        } else if (dynamicEntities.getSwap() == 2) {
            dynamicEntities.setImg(Sprite.player_down_1.getFxImage());
            dynamicEntities.setSwap(3);
        } else if (dynamicEntities.getSwap() == 3) {
            dynamicEntities.setImg(Sprite.player_down.getFxImage());
            dynamicEntities.setSwap(4);
        } else {
            dynamicEntities.setImg(Sprite.player_down_2.getFxImage());
            dynamicEntities.setSwap(1);
        }

    }
    public static void moveLeft(DynamicEntities dynamicEntities) {
//        dynamicEntities.setDirection(3);
//        dynamicEntities.setCount(4 / 1);
//        checkRun(dynamicEntities);
        if (dynamicEntities.getSwap() == 1) {
            dynamicEntities.setImg(Sprite.player_left.getFxImage());
            dynamicEntities.setSwap(2);
        } else if (dynamicEntities.getSwap() == 2) {
            dynamicEntities.setImg(Sprite.player_left_1.getFxImage());
            dynamicEntities.setSwap(3);
        } else if (dynamicEntities.getSwap() == 3) {
            dynamicEntities.setImg(Sprite.player_left.getFxImage());
            dynamicEntities.setSwap(4);
        } else {
            dynamicEntities.setImg(Sprite.player_left_2.getFxImage());
            dynamicEntities.setSwap(1);
        }
        dynamicEntities.setX(dynamicEntities.getX() - 16);
    }

    private static void left_step(DynamicEntities dynamicEntities) {
        if (dynamicEntities.getSwap() == 1) {
            dynamicEntities.setImg(Sprite.player_left.getFxImage());
            dynamicEntities.setSwap(2);
        } else if (dynamicEntities.getSwap() == 2) {
            dynamicEntities.setImg(Sprite.player_left_1.getFxImage());
            dynamicEntities.setSwap(3);
        } else if (dynamicEntities.getSwap() == 3) {
            dynamicEntities.setImg(Sprite.player_left.getFxImage());
            dynamicEntities.setSwap(4);
        } else {
            dynamicEntities.setImg(Sprite.player_left_2.getFxImage());
            dynamicEntities.setSwap(1);
        }
    }

    public static void moveRight(DynamicEntities dynamicEntities) {
//        dynamicEntities.setDirection(4);
//        dynamicEntities.setCount(4 / 1);
//        checkRun(dynamicEntities);
        if (dynamicEntities instanceof Bomber && dynamicEntities.getX() % 8 == 0) {
            if (dynamicEntities.getSwap() == 1) {
                dynamicEntities.setImg(Sprite.player_right.getFxImage());
                dynamicEntities.setSwap(2);
            } else if (dynamicEntities.getSwap() == 2) {
                dynamicEntities.setImg(Sprite.player_right_1.getFxImage());
                dynamicEntities.setSwap(3);
            } else if (dynamicEntities.getSwap() == 3) {
                dynamicEntities.setImg(Sprite.player_right.getFxImage());
                dynamicEntities.setSwap(4);
            } else {
                dynamicEntities.setImg(Sprite.player_right_2.getFxImage());
                dynamicEntities.setSwap(1);
            }
        }
        dynamicEntities.setX(dynamicEntities.getX() + 16);
    }

    public static void right_step(DynamicEntities dynamicEntities) {
        if (dynamicEntities.getSwap() == 1) {
            dynamicEntities.setImg(Sprite.player_right.getFxImage());
            dynamicEntities.setSwap(2);
        } else if (dynamicEntities.getSwap() == 2) {
            dynamicEntities.setImg(Sprite.player_right_1.getFxImage());
            dynamicEntities.setSwap(3);
        } else if (dynamicEntities.getSwap() == 3) {
            dynamicEntities.setImg(Sprite.player_right.getFxImage());
            dynamicEntities.setSwap(4);
        } else {
            dynamicEntities.setImg(Sprite.player_right_2.getFxImage());
            dynamicEntities.setSwap(1);
        }
    }


}
