package uet.oop.bomberman.entities.dynamic;

import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;
import static uet.oop.bomberman.entities.blocks.Bomb.*;
import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.controller.Movement.*;
public class Kondoria extends DynamicEntities {
    public static int kondoriaStep = 2;
    private int countKondoriaDead = 0;
    public Kondoria(int x, int y, Image img) {
        super(x, y, img);
    }
    public void kondoriaMove() {

    }
    public void killKondoria() {
        this.setImg(Sprite.movingSprite(Sprite.kondoria_dead,Sprite.mob_dead1,Sprite.mob_dead2,countKondoriaDead,60).getFxImage());
        countKondoriaDead++;
        if (countKondoriaDead > decayTimer) {
            for (int i=0;i<enemy.size();i++) {
                if (enemy.get(i).getX() == this.getX() && enemy.get(i).getY() == this.getY()) {
                    enemy.remove(i);
                }
            }
        }
    }
    @Override
    public void update() {
        kondoriaMove();
        checkAlive();
        if (!life) {
            killKondoria();
        }
    }
}