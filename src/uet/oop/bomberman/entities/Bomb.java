package uet.oop.bomberman.entities;

import javafx.scene.image.Image;

public class Bomb extends AnimatedEntity {

    private int timeToExplode = 120;    //2s
    private int decayTimer = 30;
    private boolean allowToWalkOn = true;
    private boolean exploded = false;
    public Bomb(int x, int y, Image boom) {
        super(x, y, boom);
    }
    protected void explode() {

    }
    /**
     *
     */
    @Override
    public void update() {
        if (timeToExplode > 0) {
            timeToExplode--;
        } else {
            if (!exploded) explode();
            if (decayTimer > 0) {
                decayTimer--;
            } else {
                //remove()
            }
        }
        animation();

    }

    /**
     *
     */
    @Override
    public void playAnimation() {

    }
}
