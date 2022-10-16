package uet.oop.bomberman.controller;

import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.dynamic.*;

import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.entities.dynamic.Bomber.*;
import static uet.oop.bomberman.entities.dynamic.Ballom.*;
import javafx.scene.input.KeyEvent;
import uet.oop.bomberman.graphics.Sprite;

public class Movement {
    public static int countBomberStep = 0;
    public static boolean keyup = false;
    public static boolean keydown = false;
    public static boolean keyleft = false;
    public static boolean keyright = false;
    public static boolean collision(int ax, int ay, int bx, int by) {
        if (ax < bx + Sprite.SCALED_SIZE &&
                ax + Sprite.SCALED_SIZE - 8 > bx &&
                ay < by + Sprite.SCALED_SIZE &&
                ay + Sprite.SCALED_SIZE > by) {
            return true;
        }
        return false;
    }

    public static boolean canMoveDown(DynamicEntities dynamicEntities) {
        if (dynamicEntities instanceof Bomber) {
            for (int i = 0; i < block.size(); i++) {
                if (collision(dynamicEntities.getX(), dynamicEntities.getY() + bomberStep, block.get(i).getX(), block.get(i).getY())) {
                    return false;
                }
            }
            return true;
        } else if (dynamicEntities instanceof Ballom) {
            for (int i = 0; i < block.size(); i++) {
                if (collision(dynamicEntities.getX(), dynamicEntities.getY() + ballomStep, block.get(i).getX(), block.get(i).getY())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static boolean canMoveUp(DynamicEntities dynamicEntities) {
        if (dynamicEntities instanceof Bomber) {
            for (int i = 0; i < block.size(); i++) {
                if (collision(dynamicEntities.getX(), dynamicEntities.getY() - bomberStep, block.get(i).getX(), block.get(i).getY())) {
                    return false;
                }
            }
            return true;
        } else if (dynamicEntities instanceof Ballom) {
            for (int i = 0; i < block.size(); i++) {
                if (collision(dynamicEntities.getX(), dynamicEntities.getY() - ballomStep, block.get(i).getX(), block.get(i).getY())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static boolean canMoveLeft(DynamicEntities dynamicEntities) {
        if (dynamicEntities instanceof Bomber) {
            for (Entity entity : block) {
                if (collision(dynamicEntities.getX() - bomberStep, dynamicEntities.getY(), entity.getX(), entity.getY())) {
                    return false;
                }
            }
            return true;
        } else if (dynamicEntities instanceof Ballom) {
            for (Entity entity : block) {
                if (collision(dynamicEntities.getX() - ballomStep, dynamicEntities.getY(), entity.getX(), entity.getY())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static boolean canMoveRight(DynamicEntities dynamicEntities) {
        if (dynamicEntities instanceof Bomber) {
            for (Entity entity : block) {
                if (collision(dynamicEntities.getX() + bomberStep, dynamicEntities.getY(), entity.getX(), entity.getY())) {
                    return false;
                }
            }
            return true;
        } else if (dynamicEntities instanceof Ballom) {
            for (Entity entity : block) {
                if (collision(dynamicEntities.getX() + ballomStep, dynamicEntities.getY(), entity.getX(), entity.getY())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static void moveUp(DynamicEntities dynamicEntities) {
        if (dynamicEntities instanceof Bomber) {
            countBomberStep++;
            dynamicEntities.setImg(Sprite.movingSprite(Sprite.player_up, Sprite.player_up_1, Sprite.player_up_2, countBomberStep, 54).getFxImage());
            if (countBomberStep > 10000) {
                countBomberStep = 0;
            }
            if (canMoveUp(dynamicEntities)) {
                dynamicEntities.setY(dynamicEntities.getY() - bomberStep);
            }
        }
        if (dynamicEntities instanceof Ballom) {
            dynamicEntities.setImg(Sprite.movingSprite(Sprite.balloom_right1, Sprite.balloom_right2, Sprite.balloom_right3, dynamicEntities.getY(), 100).getFxImage());
            if (canMoveDown(dynamicEntities)) {
                dynamicEntities.setY(dynamicEntities.getY() - ballomStep);
            }
        }

    }

    public static void moveDown(DynamicEntities dynamicEntities) {
        if (dynamicEntities instanceof Bomber) {
            countBomberStep++;
            dynamicEntities.setImg(Sprite.movingSprite(Sprite.player_down, Sprite.player_down_1, Sprite.player_down_2, countBomberStep, 54).getFxImage());
            if (countBomberStep > 10000) {
                countBomberStep = 0;
            }
            if (canMoveDown(dynamicEntities)) {
                dynamicEntities.setY(dynamicEntities.getY() + bomberStep);
            }
        }
        if (dynamicEntities instanceof Ballom) {
            dynamicEntities.setImg(Sprite.movingSprite(Sprite.balloom_left1, Sprite.balloom_left2, Sprite.balloom_left3, dynamicEntities.getY(), 100).getFxImage());
            if (canMoveDown(dynamicEntities)) {
                dynamicEntities.setY(dynamicEntities.getY() + ballomStep);
            }
        }
    }

    public static void moveLeft(DynamicEntities dynamicEntities) {
        if (dynamicEntities instanceof Bomber) {
            countBomberStep++;
            dynamicEntities.setImg(Sprite.movingSprite(Sprite.player_left, Sprite.player_left_1, Sprite.player_left_2, countBomberStep, 54).getFxImage());
            if (countBomberStep > 10000) {
                countBomberStep = 0;
            }
            if (canMoveLeft(dynamicEntities)) {
                dynamicEntities.setX(dynamicEntities.getX() - bomberStep);
            }
        }
        if (dynamicEntities instanceof Ballom) {
            dynamicEntities.setImg(Sprite.movingSprite(Sprite.balloom_left1, Sprite.balloom_left2, Sprite.balloom_left3, dynamicEntities.getY(), 100).getFxImage());
            if (canMoveDown(dynamicEntities)) {
                dynamicEntities.setX(dynamicEntities.getX() - ballomStep);
            }
        }
    }


    public static void moveRight(DynamicEntities dynamicEntities) {
        if (dynamicEntities instanceof Bomber) {
            countBomberStep++;
            dynamicEntities.setImg(Sprite.movingSprite(Sprite.player_right, Sprite.player_right_1, Sprite.player_right_2, countBomberStep, 54).getFxImage());
            if (countBomberStep > 10000) {
                countBomberStep = 0;
            }
            if (canMoveRight(dynamicEntities)) {
                dynamicEntities.setX(dynamicEntities.getX() + bomberStep);
            }
        }
        if (dynamicEntities instanceof Ballom) {
            dynamicEntities.setImg(Sprite.movingSprite(Sprite.balloom_right1, Sprite.balloom_right2, Sprite.balloom_right3, dynamicEntities.getY(), 100).getFxImage());
            if (canMoveDown(dynamicEntities)) {
                dynamicEntities.setX(dynamicEntities.getX() + ballomStep);
            }
        }
    }


}

