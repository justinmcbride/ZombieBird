package com.justin.ZombieBird;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
/**
 * Created by Justin on 7/3/2014.
 */
public class GameScreen implements Screen {
    private GameWorld gameWorld;
    private GameRenderer gameRenderer;

    public GameScreen() {
        System.out.println("GameScreen Attached");

        gameWorld = new GameWorld();
        gameRenderer = new GameRenderer(gameWorld);
    }

    @Override
    public void render(float delta) {
        gameWorld.update(delta);
        gameRenderer.render();
    }

    @Override
    public void resize(int width, int height) {
        System.out.println("GameScreen - resizing");
    }

    @Override
    public void show() {
        System.out.println("GameScreen - show");
    }

    @Override
    public void hide() {
        System.out.println("GameScreen - hide");
    }

    @Override
    public void pause() {
        System.out.println("GameScreen - pause");
    }

    @Override
    public void resume() {
        System.out.println("GameScreen - resume");
    }

    @Override
    public void dispose() {

    }
}
