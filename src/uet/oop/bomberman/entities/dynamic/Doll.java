package uet.oop.bomberman.entities.dynamic;

import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;
import static uet.oop.bomberman.entities.blocks.Bomb.*;
import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.controller.Movement.*;
public class Doll extends DynamicEntities {
    public static int dollStep = 2;
    private int countDollDead = 0;
    public Doll(int x, int y, Image img) {
        super(x, y, img);
    }
    public void dollMove() {

    }
    public void killDoll() {
        this.setImg(Sprite.movingSprite(Sprite.doll_dead,Sprite.mob_dead1,Sprite.mob_dead2,countDollDead,60).getFxImage());
        countDollDead++;
        if (countDollDead > decayTimer) {
            for (int i=0;i<enemy.size();i++) {
                if (enemy.get(i).getX() == this.getX() && enemy.get(i).getY() == this.getY()) {
                    enemy.remove(i);
                }
            }
        }
    }
    @Override
    public void update() {
        dollMove();
        checkAlive();
        if (!life) {
            killDoll();
        }
    }
}
