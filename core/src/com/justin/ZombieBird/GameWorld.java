package com.justin.ZombieBird;

import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Justin on 7/3/2014.
 */
public class GameWorld {
    private Rectangle rect = new Rectangle(0, 0, 17, 23);

    public void update(float delta) {
        System.out.println("gameworld- update");
        rect.x++;
        if (rect.x > 137) {
            rect.x = 0;
        }
    }

    public Rectangle getRect() {
        return rect;
    }
}
