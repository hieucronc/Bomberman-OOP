package uet.oop.bomberman.entities.dynamic;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Entity;

public abstract class DynamicEntities extends Entity {
    protected int isMove;
    protected int swapImg;
    protected int direction;

    public DynamicEntities() {

    }

    public DynamicEntities(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    public DynamicEntities(int isMove, int swapImg, int direction) {
        this.isMove = isMove;
        this.swapImg = swapImg;
        this.direction = direction;
    }

    public int getIsMove() {
        return isMove;
    }

    public void setIsMove(int isMove) {
        this.isMove = isMove;
    }

    public int getswapImg() {
        return swapImg;
    }

    public void setswapImg(int swapImg) {
        this.swapImg = swapImg;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.swapImg = direction;
    }
}
