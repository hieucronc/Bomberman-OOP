package uet.oop.bomberman.entities.items;
import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;
import static uet.oop.bomberman.BombermanGame.*;
public class FlamePassItem extends Items {
    public static boolean takeFlamePass = false;
    public FlamePassItem(int x,int y, Image image) {
        super(x, y, image);
    }
    @Override
    public void update() {
        if (checkBomb()) {
            broken = true;
            reveal(Sprite.powerup_flamepass.getFxImage(),2);
        }
        if (takeItem()) {
            items.remove(isInItem(this));
            takeFlamePass = true;
        }
    }
}
