package com.justin.ZombieBird;

import com.badlogic.gdx.math.Intersector;
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
    private Rectangle ground;

    private int score = 0;

    public GameWorld(int midPointY) {
        bird = new Bird(33, midPointY - 5, 17, 12);
        scroller = new ScrollHandler(midPointY + 66);
        ground = new Rectangle(0, midPointY + 66, 136, 11);
    }

    public int getScore() {
        return score;
    }

    public void addScore(int increment) {
        score += increment;
    }

    public void update(float delta) {

        if (delta > .15f) {
            delta = .15f;
        }
        bird.update(delta);
        scroller.update(delta);

        if (scroller.collides(bird)) {
            scroller.stop();
            bird.die();
            AssetLoader.dead.play();
        }

        if (Intersector.overlaps(bird.getBoundingCircle(), ground)) {
            scroller.stop();
            bird.die();
            bird.decelerate();
        }
    }

    public ScrollHandler getScroller() {
        return scroller;
    }

    public Bird getBird() {
        return bird;
    }

}
