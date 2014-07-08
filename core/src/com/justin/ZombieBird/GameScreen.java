package com.justin.ZombieBird;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.justin.ZBHelpers.InputHandler;

/**
 * Created by Justin on 7/3/2014.
 */
public class GameScreen implements Screen {
    private GameWorld gameWorld;
    private GameRenderer gameRenderer;
    private float runTime = 0;

    public GameScreen() {
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float gameWidth = 136;
        float gameHeight = screenHeight / (screenWidth / gameWidth);

        int midPointY = (int)(gameHeight / 2);


        gameWorld = new GameWorld(midPointY);
        gameRenderer = new GameRenderer(gameWorld, (int)gameHeight, midPointY);

        Gdx.input.setInputProcessor(new InputHandler(gameWorld.getBird()));
    }

    @Override
    public void render(float delta) {
        runTime += delta;
        gameWorld.update(delta);
        gameRenderer.render(runTime);
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
