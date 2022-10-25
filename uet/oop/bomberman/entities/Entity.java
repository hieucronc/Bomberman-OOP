package uet.oop.bomberman.entities;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.controller.Movement;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.*;

public abstract class Entity {
    //Tọa độ X tính từ góc trái trên trong Canvas
    protected int x;

    //Tọa độ Y tính từ góc trái trên trong Canvas
    protected int y;

    protected Image img;

    public static int frameCount = 0;

    public Entity() {

    }

    //Khởi tạo đối tượng, chuyển từ tọa độ đơn vị sang tọa độ trong canvas
    public Entity(int xUnit, int yUnit, Image img) {
        this.x = xUnit * Sprite.SCALED_SIZE;
        this.y = yUnit * Sprite.SCALED_SIZE;
        this.img = img;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void render(GraphicsContext gc) {
        gc.drawImage(img, x, y);
    }


    public boolean checkBomb() {
        for (Entity entity : flame) {
            if (Movement.collision(entity, entity.getX(), entity.getY(), this.getX(), this.getY())) {
                return true;
            }
        }
        return false;
    }

    public static int isInItem(Entity entity) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getX() == entity.getX() && items.get(i).getY() == entity.getY()) {
                return i;
            }
        }
        return -1;
    }


    public abstract void update() throws Exception;
}
