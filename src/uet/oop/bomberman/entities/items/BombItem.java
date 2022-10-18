package uet.oop.bomberman.entities.items;
import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;
import static uet.oop.bomberman.BombermanGame.*;
public class BombItem extends Items{
    public BombItem(int x,int y,Image image) {
        super(x, y, image);
    }
    @Override
    public void update() {
        if (checkBomb()) {
            broken = true;
            reveal(Sprite.powerup_bombs.getFxImage());
        }
        if (takeItem()) {
            items.remove(isInItem(this));
        }
    }

}
