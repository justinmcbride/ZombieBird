package com.justin.ZombieBird;

import com.badlogic.gdx.math.Rectangle;
import com.justin.GameObjects.Bird;
import com.justin.GameObjects.ScrollHandler;
import com.justin.ZBHelpers.AssetLoader;

/**
 * Created by Justin on 7/3/2014.
 */
public class GameWorld {
    private Bird bird;
    private ScrollHandler scroller;
    private boolean isAlive = true;

    public GameWorld(int midPointY) {
        bird = new Bird(33, midPointY - 5, 17, 12);
        scroller = new ScrollHandler(midPointY + 66);
    }

    public void update(float delta) {
        bird.update(delta);
        scroller.update(delta);

        if (isAlive && scroller.collides(bird)) {
            scroller.stop();
            AssetLoader.dead.play();
            isAlive = false;
        };
    }

    public ScrollHandler getScroller() {
        return scroller;
    }

    public Bird getBird() {
        return bird;
    }

}
