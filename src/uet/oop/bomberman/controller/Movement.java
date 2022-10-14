package uet.oop.bomberman.controller;

import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.dynamic.*;

import static uet.oop.bomberman.BombermanGame.*;

import javafx.scene.input.KeyEvent;
import uet.oop.bomberman.graphics.Sprite;

public class Movement {
    public static boolean collision(int ax, int ay, int bx, int by) {
        if (ax < bx + 32 &&
                ax + 24 > bx &&
                ay < by + 32 &&
                ay + 32 > by) {
            return true;
        }
        return false;
    }

    public static boolean canMoveDown(DynamicEntities dynamicEntities) {
        if (dynamicEntities instanceof Bomber) {
            for (int i = 0; i < block.size(); i++) {
                if (collision(dynamicEntities.getX(), dynamicEntities.getY() + 4, block.get(i).getX(), block.get(i).getY())) {
                    return false;
                }
            }
            return true;
        } else if (dynamicEntities instanceof Ballom) {
            for (int i = 0; i < block.size(); i++) {
                if (collision(dynamicEntities.getX(), dynamicEntities.getY() + 1, block.get(i).getX(), block.get(i).getY())) {
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
                if (collision(dynamicEntities.getX(), dynamicEntities.getY() - 4, block.get(i).getX(), block.get(i).getY())) {
                    return false;
                }
            }
            return true;
        } else if (dynamicEntities instanceof Ballom) {
            for (int i = 0; i < block.size(); i++) {
                if (collision(dynamicEntities.getX(), dynamicEntities.getY() - 1, block.get(i).getX(), block.get(i).getY())) {
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
                if (collision(dynamicEntities.getX() - 4, dynamicEntities.getY(), entity.getX(), entity.getY())) {
                    return false;
                }
            }
            return true;
        } else if (dynamicEntities instanceof Ballom) {
            for (Entity entity : block) {
                if (collision(dynamicEntities.getX() - 1, dynamicEntities.getY(), entity.getX(), entity.getY())) {
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
                if (collision(dynamicEntities.getX() + 4, dynamicEntities.getY(), entity.getX(), entity.getY())) {
                    return false;
                }
            }
            return true;
        } else if (dynamicEntities instanceof Ballom) {
            for (Entity entity : block) {
                if (collision(dynamicEntities.getX() + 1, dynamicEntities.getY(), entity.getX(), entity.getY())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static void moveUp(DynamicEntities dynamicEntities) {
        if (dynamicEntities instanceof Bomber) {
            dynamicEntities.setImg(Sprite.movingSprite(Sprite.player_up, Sprite.player_up_1, Sprite.player_up_2, dynamicEntities.getY(), 54).getFxImage());
            if (canMoveUp(dynamicEntities)) {
                dynamicEntities.setY(dynamicEntities.getY() - 4);
            }
        }
        if (dynamicEntities instanceof Ballom) {
            dynamicEntities.setImg(Sprite.movingSprite(Sprite.balloom_right1, Sprite.balloom_right2, Sprite.balloom_right3, dynamicEntities.getY(), 100).getFxImage());
            if (canMoveDown(dynamicEntities)) {
                dynamicEntities.setY(dynamicEntities.getY() - 1);
            }
        }

    }

    public static void moveDown(DynamicEntities dynamicEntities) {
        if (dynamicEntities instanceof Bomber) {
            dynamicEntities.setImg(Sprite.movingSprite(Sprite.player_down, Sprite.player_down_1, Sprite.player_down_2, dynamicEntities.getY(), 54).getFxImage());
            if (canMoveDown(dynamicEntities)) {
                dynamicEntities.setY(dynamicEntities.getY() + 4);
            }
        }
        if (dynamicEntities instanceof Ballom) {
            dynamicEntities.setImg(Sprite.movingSprite(Sprite.balloom_left1, Sprite.balloom_left2, Sprite.balloom_left3, dynamicEntities.getY(), 100).getFxImage());
            if (canMoveDown(dynamicEntities)) {
                dynamicEntities.setY(dynamicEntities.getY() + 1);
            }
        }
    }

    public static void moveLeft(DynamicEntities dynamicEntities) {
        if (dynamicEntities instanceof Bomber) {
            dynamicEntities.setImg(Sprite.movingSprite(Sprite.player_left, Sprite.player_left_1, Sprite.player_left_2, dynamicEntities.getX(), 54).getFxImage());
            if (canMoveLeft(dynamicEntities)) {
                dynamicEntities.setX(dynamicEntities.getX() - 4);
            }
        }
        if (dynamicEntities instanceof Ballom) {
            dynamicEntities.setImg(Sprite.movingSprite(Sprite.balloom_left1, Sprite.balloom_left2, Sprite.balloom_left3, dynamicEntities.getY(), 100).getFxImage());
            if (canMoveDown(dynamicEntities)) {
                dynamicEntities.setX(dynamicEntities.getX() - 1);
            }
        }
    }


    public static void moveRight(DynamicEntities dynamicEntities) {
        if (dynamicEntities instanceof Bomber) {
            dynamicEntities.setImg(Sprite.movingSprite(Sprite.player_right, Sprite.player_right_1, Sprite.player_right_2, dynamicEntities.getX(), 54).getFxImage());
            if (canMoveRight(dynamicEntities)) {
                dynamicEntities.setX(dynamicEntities.getX() + 4);
            }
        }
        if (dynamicEntities instanceof Ballom) {
            dynamicEntities.setImg(Sprite.movingSprite(Sprite.balloom_right1, Sprite.balloom_right2, Sprite.balloom_right3, dynamicEntities.getY(), 100).getFxImage());
            if (canMoveDown(dynamicEntities)) {
                dynamicEntities.setX(dynamicEntities.getX() + 1);
            }
        }
    }


}

