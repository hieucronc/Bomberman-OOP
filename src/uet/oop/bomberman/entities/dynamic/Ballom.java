package uet.oop.bomberman.entities.dynamic;

import javafx.scene.image.Image;
import uet.oop.bomberman.controller.Movement;

import java.util.Random;

public class Ballom extends DynamicEntities {
    int cnt = 0;
    public Ballom(int x, int y, Image img) {
        super(x,y,img);
    }
    @Override
    public void update() {
//        Random random = new Random();
//        int dir = random.nextInt(4);
//        int cnt = 0,cnt1 = 0, cnt2 = 0, cnt3 = 0;
//        switch (dir) {
//            case 0:
//                if (cnt < 10) {
//                    Movement.moveDown(this);
//                    cnt ++;
//                } else {
//                    cnt = 0;
//                }
//
//                break;
//            case 1:
//                if (cnt1 < 10) {
//                    Movement.moveUp(this);
//                    cnt1 ++;
//                } else {
//                    cnt1 = 0;
//                }
//                break;
//            case 2:
//
//                if (cnt2 < 10) {
//                    Movement.moveLeft(this);
//                    cnt2 ++;
//                } else {
//                    cnt2 = 0;
//                }
//                break;
//            case 3:
//
//                if (cnt3 < 10) {
//                    Movement.moveRight(this);
//                    cnt3 ++;
//                } else {
//                    cnt3 = 0;
//                }
//                break;
//            default:
//                break;
//        }
        if (Movement.canMoveDown(this)) {
            Movement.moveDown(this);
        }
//        } else if (Movement.canMoveUp(this)) {
//            Movement.moveUp(this);
//        } else if (Movement.canMoveRight(this)) {
//            Movement.moveRight(this);
//        } else {
//            Movement.moveLeft(this);
//        }



//        if (cnt < 10) {
//            if (Movement.canMoveDown(this)) {
//                Movement.moveDown(this);
//                cnt ++;
//            } else {
//                Random random = new Random();
//                cnt = random.nextInt(10) + 10;
//            }
//
//        } else {
//            Random random = new Random();
//            cnt = random.nextInt(20);
//        }
//
//        if (cnt > 10 && cnt < 20) {
//            if  (Movement.canMoveUp(this)) {
//                Movement.moveUp(this);
//                cnt++;
//            } else {
//                Random random = new Random();
//                cnt = random.nextInt(20);
//            }
//
//        } else if (cnt > 20) {
//            Random random = new Random();
//            cnt = random.nextInt(20);
//        }
    }
}