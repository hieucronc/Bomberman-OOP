package uet.oop.bomberman.controller;
import uet.oop.bomberman.entities.dynamic.*;
import static uet.oop.bomberman.BombermanGame.*;
import javafx.scene.input.KeyEvent;
import uet.oop.bomberman.graphics.Sprite;

public class Movement {
//    position
//    public static void checkRun(DynamicEntities dynamicEntities) {
//        setDirection(dynamicEntities.getDirection(), dynamicEntities, 1);
//        //dynamicEntities.setCount(dynamicEntities.getCount() - 1);
//    }
    public static boolean canMoveDown(DynamicEntities dynamicEntities) {
        int x = dynamicEntities.getX() / 32;
        int y = dynamicEntities.getY() / 32;
        return position[x][y+1] == 0;
    }
    public static boolean canMoveUp(DynamicEntities dynamicEntities) {
        int x = dynamicEntities.getX() / 32;
        int y = dynamicEntities.getY() / 32;
        return position[x][y-1] == 0;
    }
    public static boolean canMoveLeft(DynamicEntities dynamicEntities) {
        int x = dynamicEntities.getX() / 32;
        int y = dynamicEntities.getY() / 32;
        return position[x-1][y] == 0;
    }
    public static boolean canMoveRight(DynamicEntities dynamicEntities) {
        int x = dynamicEntities.getX() / 32;
        int y = dynamicEntities.getY() / 32;
        return position[x+1][y] == 0;
    }
//    private static void setDirection(int direction, DynamicEntities dynamicEntities, int isMove) {
//        switch (direction) {
//            case 1:  // down
//                down_step(dynamicEntities);
//                dynamicEntities.setY(dynamicEntities.getY() + isMove);
//                break;
//            case 2: // up
//                up_step(dynamicEntities);
//                dynamicEntities.setY(dynamicEntities.getY() - isMove);
//                break;
//            case 3: // left
//                left_step(dynamicEntities);
//                dynamicEntities.setX(dynamicEntities.getX() - isMove);
//                break;
//            case 4: // right
//                right_step(dynamicEntities);
//                dynamicEntities.setX(dynamicEntities.getX() + isMove);
//                break;
//        }
//    }

    public static void moveUp(DynamicEntities dynamicEntities) {
        upStep(dynamicEntities);
        if (canMoveUp(dynamicEntities) == true)  {
            dynamicEntities.setY(dynamicEntities.getY() - 32);
        }

    }

    private static void upStep(DynamicEntities dynamicEntities) {
        if (dynamicEntities.getswapImg() == 1) {
            dynamicEntities.setImg(Sprite.player_up.getFxImage());
            dynamicEntities.setswapImg(2);
        } else if (dynamicEntities.getswapImg() == 2) {
            dynamicEntities.setImg(Sprite.player_up_1.getFxImage());
            dynamicEntities.setswapImg(3);
        } else if (dynamicEntities.getswapImg() == 3) {
            dynamicEntities.setImg(Sprite.player_up.getFxImage());
            dynamicEntities.setswapImg(4);
        } else {
            dynamicEntities.setImg(Sprite.player_up_2.getFxImage());
            dynamicEntities.setswapImg(1);
        }
    }

    public static void moveDown(DynamicEntities dynamicEntities) {
        downStep(dynamicEntities);
        if (canMoveDown(dynamicEntities) == true) {
            dynamicEntities.setY(dynamicEntities.getY() + 32);
        }
    }
    private static void downStep(DynamicEntities dynamicEntities) {
        if (dynamicEntities.getswapImg() == 1) {
            dynamicEntities.setImg(Sprite.player_down.getFxImage());
            dynamicEntities.setswapImg(2);
        } else if (dynamicEntities.getswapImg() == 2) {
            dynamicEntities.setImg(Sprite.player_down_1.getFxImage());
            dynamicEntities.setswapImg(3);
        } else if (dynamicEntities.getswapImg() == 3) {
            dynamicEntities.setImg(Sprite.player_down.getFxImage());
            dynamicEntities.setswapImg(4);
        } else {
            dynamicEntities.setImg(Sprite.player_down_2.getFxImage());
            dynamicEntities.setswapImg(1);
        }

    }
    public static void moveLeft(DynamicEntities dynamicEntities) {
        leftStep(dynamicEntities);
        if (canMoveLeft(dynamicEntities) == true) {
            dynamicEntities.setX(dynamicEntities.getX() - 32);
        }
    }

    private static void leftStep(DynamicEntities dynamicEntities) {
        if (dynamicEntities.getswapImg() == 1) {
            dynamicEntities.setImg(Sprite.player_left.getFxImage());
            dynamicEntities.setswapImg(2);
        } else if (dynamicEntities.getswapImg() == 2) {
            dynamicEntities.setImg(Sprite.player_left_1.getFxImage());
            dynamicEntities.setswapImg(3);
        } else if (dynamicEntities.getswapImg() == 3) {
            dynamicEntities.setImg(Sprite.player_left.getFxImage());
            dynamicEntities.setswapImg(4);
        } else {
            dynamicEntities.setImg(Sprite.player_left_2.getFxImage());
            dynamicEntities.setswapImg(1);
        }
    }

    public static void moveRight(DynamicEntities dynamicEntities) {
        rightStep(dynamicEntities);
        if (canMoveRight(dynamicEntities) == true) {
            dynamicEntities.setX(dynamicEntities.getX() + 32);
        }

    }

    public static void rightStep(DynamicEntities dynamicEntities) {
        if (dynamicEntities.getswapImg() == 1) {
            dynamicEntities.setImg(Sprite.player_right.getFxImage());
            dynamicEntities.setswapImg(2);
        } else if (dynamicEntities.getswapImg() == 2) {
            dynamicEntities.setImg(Sprite.player_right_1.getFxImage());
            dynamicEntities.setswapImg(3);
        } else if (dynamicEntities.getswapImg() == 3) {
            dynamicEntities.setImg(Sprite.player_right.getFxImage());
            dynamicEntities.setswapImg(4);
        } else {
            dynamicEntities.setImg(Sprite.player_right_2.getFxImage());
            dynamicEntities.setswapImg(1);
        }
    }


}
