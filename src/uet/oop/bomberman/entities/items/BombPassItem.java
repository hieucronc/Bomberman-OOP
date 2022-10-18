package uet.oop.bomberman.entities.items;
import uet.oop.bomberman.entities.Entity;
import javafx.scene.image.Image;
import uet.oop.bomberman.entities.blocks.Bomb;
import uet.oop.bomberman.graphics.Sprite;
import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.entities.dynamic.Bomber.*;
public class BombPassItem extends Items {
    public static boolean takeBombPass = false;
    public BombPassItem(int x,int y, Image image) {
        super(x, y, image);
    }
    @Override
    public void update() {
        if (checkBomb()) {
            img = Sprite.powerup_bombpass.getFxImage();
            block.remove(isInBlock(this));
        }
        if (takeItem()) {
            items.remove(isInItem(this));
            takeBombPass = true;
        }
    }
}
