package uet.oop.bomberman.entities.blocks;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.*;

public class Brick extends Entity {
    public int cntBrickExploded = 0;
    private boolean broken = false;
    private int decayTimer = 30;

    public Brick(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    public boolean checkBomb() {
        for (Entity entity : flame) {
            if (entity.getX() == this.getX() && entity.getY() == this.getY()) {
                return true;
            }
        }
        return false;
    }

    public void removeBrick() {
        for (int i = 0; i < block.size(); i++) {
            if (block.get(i) instanceof Brick) {
                if (block.get(i).getX() == this.x && block.get(i).getY() == this.y) {
                    position[((Brick) block.get(i)).getY() / Sprite.SCALED_SIZE]
                            [((Brick) block.get(i)).getX() / Sprite.SCALED_SIZE] = 0;
                    cntBrickExploded = 0;
                    block.remove(i);
                    break;
                }
            }
        }
    }

    public void playImg() {
        this.setImg(Sprite.movingSprite(Sprite.brick_exploded, Sprite.brick_exploded1,
                Sprite.brick_exploded2, cntBrickExploded, decayTimer).getFxImage());
        cntBrickExploded++;
    }

    @Override
    public void update() {
        if (checkBomb()) {
            broken = true;
        }
        if (broken) {
            playImg();
            if (cntBrickExploded > decayTimer)
                removeBrick();
        }
    }
}
