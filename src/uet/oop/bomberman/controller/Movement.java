package uet.oop.bomberman.controller;

import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.dynamic.*;

import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.entities.dynamic.Bomber.*;
import static uet.oop.bomberman.entities.dynamic.Ballom.*;
import static uet.oop.bomberman.entities.dynamic.Doll.dollStep;
import static uet.oop.bomberman.entities.dynamic.Oneal.*;

import javafx.scene.input.KeyEvent;
import uet.oop.bomberman.graphics.Sprite;

public class Movement {
    public static int countBomberStep = 0;
    public static boolean keyup = false;
    public static boolean keydown = false;
    public static boolean keyleft = false;
    public static boolean keyright = false;

    public static boolean collision(Entity a, int ax, int ay, int bx, int by) {
        if (a instanceof Bomber) {
            return ax < bx + Sprite.SCALED_SIZE &&
                    ax + Sprite.SCALED_SIZE - 8 > bx &&
                    ay < by + Sprite.SCALED_SIZE &&
                    ay + Sprite.SCALED_SIZE > by;
        } else {
            return ax < bx + Sprite.SCALED_SIZE &&
                    ax + Sprite.SCALED_SIZE > bx &&
                    ay < by + Sprite.SCALED_SIZE &&
                    ay + Sprite.SCALED_SIZE > by;
        }

    }

    public static boolean canMoveDown(DynamicEntities dynamicEntities) {
        if (dynamicEntities instanceof Bomber) {
            for (int i = 0; i < block.size(); i++) {
                if (collision(dynamicEntities, dynamicEntities.getX(), dynamicEntities.getY() + bomberStep, block.get(i).getX(), block.get(i).getY())) {
                    return false;
                }
            }
            return true;
        } else if (dynamicEntities instanceof Ballom) {
            for (int i = 0; i < block.size(); i++) {
                if (collision(dynamicEntities, dynamicEntities.getX(), dynamicEntities.getY() + ballomStep, block.get(i).getX(), block.get(i).getY())) {
                    return false;
                }
            }
            return true;
        } else if (dynamicEntities instanceof Oneal) {
            for (int i = 0; i < block.size(); i++) {
                if (collision(dynamicEntities, dynamicEntities.getX(), dynamicEntities.getY() + onealStep, block.get(i).getX(), block.get(i).getY())) {
                    return false;
                }
            }
            return true;
        } else if (dynamicEntities instanceof Doll) {
            for (int i = 0; i < block.size(); i++) {
                if (collision(dynamicEntities, dynamicEntities.getX(), dynamicEntities.getY() + dollStep, block.get(i).getX(), block.get(i).getY())) {
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
                if (collision(dynamicEntities, dynamicEntities.getX(), dynamicEntities.getY() - bomberStep, block.get(i).getX(), block.get(i).getY())) {
                    return false;
                }
            }
            return true;
        } else if (dynamicEntities instanceof Ballom) {
            for (int i = 0; i < block.size(); i++) {
                if (collision(dynamicEntities, dynamicEntities.getX(), dynamicEntities.getY() - ballomStep, block.get(i).getX(), block.get(i).getY())) {
                    return false;
                }
            }
            return true;
        } else if (dynamicEntities instanceof Oneal) {
            for (int i = 0; i < block.size(); i++) {
                if (collision(dynamicEntities, dynamicEntities.getX(), dynamicEntities.getY() - onealStep, block.get(i).getX(), block.get(i).getY())) {
                    return false;
                }
            }
            return true;
        } else if (dynamicEntities instanceof Doll) {
            for (int i = 0; i < block.size(); i++) {
                if (collision(dynamicEntities, dynamicEntities.getX(), dynamicEntities.getY() - dollStep, block.get(i).getX(), block.get(i).getY())) {
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
                if (collision(dynamicEntities, dynamicEntities.getX() - bomberStep, dynamicEntities.getY(), entity.getX(), entity.getY())) {
                    return false;
                }
            }
            return true;
        } else if (dynamicEntities instanceof Ballom) {
            for (Entity entity : block) {
                if (collision(dynamicEntities, dynamicEntities.getX() - ballomStep, dynamicEntities.getY(), entity.getX(), entity.getY())) {
                    return false;
                }
            }
            return true;
        } else if (dynamicEntities instanceof Oneal) {
            for (Entity entity : block) {
                if (collision(dynamicEntities, dynamicEntities.getX() - onealStep, dynamicEntities.getY(), entity.getX(), entity.getY())) {
                    return false;
                }
            }
            return true;
        } else if (dynamicEntities instanceof Doll) {
            for (Entity entity : block) {
                if (collision(dynamicEntities, dynamicEntities.getX() - dollStep, dynamicEntities.getY(), entity.getX(), entity.getY())) {
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
                if (collision(dynamicEntities, dynamicEntities.getX() + bomberStep, dynamicEntities.getY(), entity.getX(), entity.getY())) {
                    return false;
                }
            }
            return true;
        } else if (dynamicEntities instanceof Ballom) {
            for (Entity entity : block) {
                if (collision(dynamicEntities, dynamicEntities.getX() + ballomStep, dynamicEntities.getY(), entity.getX(), entity.getY())) {
                    return false;
                }
            }
            return true;
        } else if (dynamicEntities instanceof Oneal) {
            for (Entity entity : block) {
                if (collision(dynamicEntities, dynamicEntities.getX() + onealStep, dynamicEntities.getY(), entity.getX(), entity.getY())) {
                    return false;
                }
            }
            return true;
        } else if (dynamicEntities instanceof Doll) {
            for (Entity entity : block) {
                if (collision(dynamicEntities, dynamicEntities.getX() + dollStep, dynamicEntities.getY(), entity.getX(), entity.getY())) {
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
        } else if (dynamicEntities instanceof Ballom) {
            dynamicEntities.setImg(Sprite.movingSprite(Sprite.balloom_right1, Sprite.balloom_right2, Sprite.balloom_right3, dynamicEntities.getY(), 100).getFxImage());
            if (canMoveUp(dynamicEntities)) {
                dynamicEntities.setY(dynamicEntities.getY() - ballomStep);
            }
        } else if (dynamicEntities instanceof Oneal) {
            dynamicEntities.setImg(Sprite.movingSprite(Sprite.oneal_right1, Sprite.oneal_right2, Sprite.oneal_right3, dynamicEntities.getY(), 100).getFxImage());
            if (canMoveUp(dynamicEntities)) {
                dynamicEntities.setY(dynamicEntities.getY() - onealStep);
            }
        } else if (dynamicEntities instanceof Doll) {
            dynamicEntities.setImg(Sprite.movingSprite(Sprite.doll_right1, Sprite.doll_right2, Sprite.doll_right3, dynamicEntities.getY(), 100).getFxImage());
            if (canMoveUp(dynamicEntities)) {
                dynamicEntities.setY(dynamicEntities.getY() - dollStep);
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
        } else if (dynamicEntities instanceof Ballom) {
            dynamicEntities.setImg(Sprite.movingSprite(Sprite.balloom_left1, Sprite.balloom_left2, Sprite.balloom_left3, dynamicEntities.getY(), 100).getFxImage());
            if (canMoveDown(dynamicEntities)) {
                dynamicEntities.setY(dynamicEntities.getY() + ballomStep);
            }
        } else if (dynamicEntities instanceof Oneal) {
            dynamicEntities.setImg(Sprite.movingSprite(Sprite.oneal_left1, Sprite.oneal_left2, Sprite.oneal_left3, dynamicEntities.getY(), 100).getFxImage());
            if (canMoveDown(dynamicEntities)) {
                dynamicEntities.setY(dynamicEntities.getY() + onealStep);
            }
        } else if (dynamicEntities instanceof Doll) {
            dynamicEntities.setImg(Sprite.movingSprite(Sprite.doll_left1, Sprite.doll_left2, Sprite.doll_left3, dynamicEntities.getY(), 100).getFxImage());
            if (canMoveDown(dynamicEntities)) {
                dynamicEntities.setY(dynamicEntities.getY() + dollStep);
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
        } else if (dynamicEntities instanceof Ballom) {
            dynamicEntities.setImg(Sprite.movingSprite(Sprite.balloom_left1, Sprite.balloom_left2, Sprite.balloom_left3, dynamicEntities.getY(), 100).getFxImage());
            if (canMoveLeft(dynamicEntities)) {
                dynamicEntities.setX(dynamicEntities.getX() - ballomStep);
            }
        } else if (dynamicEntities instanceof Oneal) {
            dynamicEntities.setImg(Sprite.movingSprite(Sprite.oneal_left1, Sprite.oneal_left2, Sprite.oneal_left3, dynamicEntities.getY(), 100).getFxImage());
            if (canMoveLeft(dynamicEntities)) {
                dynamicEntities.setX(dynamicEntities.getX() - onealStep);
            }
        } else if (dynamicEntities instanceof Doll) {
            dynamicEntities.setImg(Sprite.movingSprite(Sprite.doll_left1, Sprite.doll_left2, Sprite.doll_left3, dynamicEntities.getY(), 100).getFxImage());
            if (canMoveLeft(dynamicEntities)) {
                dynamicEntities.setX(dynamicEntities.getX() - dollStep);
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
        } else if (dynamicEntities instanceof Ballom) {
            dynamicEntities.setImg(Sprite.movingSprite(Sprite.balloom_right1, Sprite.balloom_right2, Sprite.balloom_right3, dynamicEntities.getY(), 100).getFxImage());
            if (canMoveRight(dynamicEntities)) {
                dynamicEntities.setX(dynamicEntities.getX() + ballomStep);
            }
        } else if (dynamicEntities instanceof Oneal) {
            dynamicEntities.setImg(Sprite.movingSprite(Sprite.oneal_right1, Sprite.oneal_right2, Sprite.oneal_right3, dynamicEntities.getY(), 100).getFxImage());
            if (canMoveRight(dynamicEntities)) {
                dynamicEntities.setX(dynamicEntities.getX() + onealStep);
            }
        } else if (dynamicEntities instanceof Doll) {
            dynamicEntities.setImg(Sprite.movingSprite(Sprite.doll_right1, Sprite.doll_right2, Sprite.doll_right3, dynamicEntities.getY(), 100).getFxImage());
            if (canMoveLeft(dynamicEntities)) {
                dynamicEntities.setX(dynamicEntities.getX() + dollStep);
            }
        }
    }


}

