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
    public int midPointY;

    private int score = 0;

    public enum GameState {
        READY, RUNNING, GAMEOVER, HIGHSCORE
    }

    private GameState currentState;

    public GameWorld(int midPointY) {
        currentState = GameState.READY;
        bird = new Bird(33, midPointY - 5, 17, 12);
        scroller = new ScrollHandler(this, midPointY + 66);
        ground = new Rectangle(0, midPointY + 66, 136, 11);
        this.midPointY = midPointY;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int increment) {
        score += increment;
    }

    public void update(float delta) {
        switch (currentState) {
            case READY:
                updateReady(delta);
                break;
            case RUNNING:
                updateRunning(delta);
                break;
            default:
                break;
        }
    }

    private void updateReady(float delta) {

    }

    public boolean isHighScore() {
        return currentState == GameState.HIGHSCORE;
    }

    public void updateRunning(float delta) {

        if (delta > .15f) {
            delta = .15f;
        }
        bird.update(delta);
        scroller.update(delta);

        if (scroller.collides(bird) && bird.isAlive()) {
            scroller.stop();
            bird.die();
            AssetLoader.dead.play();
        }

        if (Intersector.overlaps(bird.getBoundingCircle(), ground)) {
            if (bird.isAlive()) AssetLoader.dead.play();
            scroller.stop();
            bird.die();
            bird.decelerate();

            if (score > AssetLoader.getHighScore()) {
                AssetLoader.setHighScore(score);
                currentState = GameState.HIGHSCORE;
            } else {
                currentState = GameState.GAMEOVER;
            }
        }
    }

    public boolean isReady() {
        if (currentState == GameState.READY) return true;
        else return false;
    }

    public void start() {
        currentState = GameState.RUNNING;
    }

    public void restart() {
        currentState = GameState.READY;
        score = 0;
        bird.onRestart(midPointY - 5);
        scroller.onRestart();
    }

    public ScrollHandler getScroller() {
        return scroller;
    }

    public Bird getBird() {
        return bird;
    }

    public boolean isGameOver() {
        if (currentState == GameState.GAMEOVER) return true;
        else return false;
    }

}
