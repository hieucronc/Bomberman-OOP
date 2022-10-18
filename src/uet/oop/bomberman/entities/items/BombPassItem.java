package uet.oop.bomberman.entities.items;
import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;
import static uet.oop.bomberman.BombermanGame.*;
public class BombPassItem extends Items {
    public static boolean takeBombPass = false;
    public BombPassItem(int x,int y, Image image) {
        super(x, y, image);
    }
    @Override
    public void update() {
        if (checkBomb()) {
            broken = true;
            reveal(Sprite.powerup_bombpass.getFxImage(),1);
        }
        if (takeItem()) {
            items.remove(isInItem(this));
            takeBombPass = true;
        }
    }
}
