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
            img = Sprite.powerup_flamepass.getFxImage();
            for (int i=0;i<block.size();i++) {
                if (block.get(i).getX() == this.getX() && block.get(i).getY() == this.getY()) {
                    block.remove(i);
                }
            }
        }
        if (takeItem()) {
            items.remove(isInItem(this));
            takeFlamePass = true;
        }
    }
}
