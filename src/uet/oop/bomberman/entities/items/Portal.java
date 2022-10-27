package uet.oop.bomberman.entities.items;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.enemy;
import static uet.oop.bomberman.sound.SoundManager.*;

public class Portal extends Items {
    private boolean callWinSound = false;

    public Portal(int x, int y, Image image) {
        super(x, y, image);
    }

    @Override
    public void update() throws Exception {
        if (checkBomb()) {
            broken = true;
            reveal(Sprite.portal.getFxImage(), 2);
        }
        if (takeItem()) {
            if (enemy.isEmpty()) {
                if (!callWinSound) {
                    levelComplete();
                    callWinSound = true;
                }
                levelComplete();
                BombermanGame.level++;
                BombermanGame.createMap();
            }
        }

    }
}
