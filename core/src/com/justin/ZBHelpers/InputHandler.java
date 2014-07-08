package com.justin.ZBHelpers;

import com.badlogic.gdx.InputProcessor;
import com.justin.GameObjects.Bird;
import com.justin.ZombieBird.GameWorld;

/**
 * Created by Justin on 7/7/2014.
 */
public class InputHandler implements InputProcessor {
    private Bird myBird;
    private GameWorld gameWorld;

    public InputHandler(GameWorld gameWorld) {
        this.gameWorld = gameWorld;
        this.myBird = gameWorld.getBird();
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if (gameWorld.isReady()) {
            gameWorld.start();
        }

        myBird.onClick();

        if (gameWorld.isGameOver() {
            gameWorld.restart();
        })
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
