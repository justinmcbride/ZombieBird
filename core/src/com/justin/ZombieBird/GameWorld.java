package com.justin.ZombieBird;

import com.badlogic.gdx.math.Rectangle;
import com.justin.GameObjects.Bird;

/**
 * Created by Justin on 7/3/2014.
 */
public class GameWorld {
    private Bird bird;

    public GameWorld(int midPointY) {
        bird = new Bird(33, midPointY - 5, 17, 12);
    }

    public void update(float delta) {
        bird.update(delta);
    }

    public Bird getBird() {
        return bird;
    }

}
