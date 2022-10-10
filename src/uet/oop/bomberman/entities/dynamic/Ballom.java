package uet.oop.bomberman.entities.dynamic;

import javafx.scene.image.Image;
import uet.oop.bomberman.controller.Movement;

import java.util.Random;

public class Ballom extends DynamicEntities {
    public Ballom(int x, int y, Image img) {
        super(x,y,img);
    }
    @Override
    public void update() {
//        Random random = new Random();
//        int dir = random.nextInt(4);
//        switch (dir) {
//            case 0:
//                Movement.moveDown(this);
//                break;
//            case 1:
//                Movement.moveUp(this);
//                break;
//            case 2:
//                Movement.moveLeft(this);
//                break;
//            case 3:
//                Movement.moveRight(this);
//                break;
//            default:
//                break;
//        }
//        while (Movement.canMoveDown(this)) {
//            Movement.moveDown(this);
//        }
        Movement.moveDown(this);
    }
}
