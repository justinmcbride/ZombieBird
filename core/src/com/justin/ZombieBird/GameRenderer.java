package com.justin.ZombieBird;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.justin.GameObjects.Bird;
import com.justin.GameObjects.Grass;
import com.justin.GameObjects.Pipe;
import com.justin.GameObjects.ScrollHandler;
import com.justin.ZBHelpers.AssetHelper;


/**
 * Created by Justin on 7/3/2014.
 */
public class GameRenderer {
    private GameWorld gameWorld;
    private OrthographicCamera camera;
    private ShapeRenderer shapeRenderer;
    private SpriteBatch batcher;
    private Bird bird;
    private ScrollHandler scroller;
    private Grass frontGrass, backGrass;
    private Pipe pipe1, pipe2, pipe3;

    private TextureRegion bg, grass;
    private Animation birdAnimation;
    private TextureRegion birdMid, birdDown, birdUp;
    private TextureRegion skullUp, skullDown, bar;

    private int midPointY;
    private int gameHeight;

    private void initGameObjects() {
        bird = gameWorld.getBird();
        scroller = gameWorld.getScroller();
        frontGrass = scroller.getFrontGrass();
        backGrass = scroller.getBackGrass();

        pipe1 = scroller.getPipe1();
        pipe2 = scroller.getPipe2();
        pipe3 = scroller.getPipe3();
    }

    private void initAssets() {
        bg = AssetHelper.bg;
        grass = AssetHelper.grass;
        birdAnimation = AssetHelper.birdAnimation;
        birdMid = AssetHelper.bird;
        birdDown = AssetHelper.birdDown;
        birdUp = AssetHelper.birdUp;

        skullUp = AssetHelper.skullUp;
        skullDown = AssetHelper.skullDown;
        bar = AssetHelper.bar;
    }

    public GameRenderer(GameWorld gameWorld, int gameHeight, int midPointY) {
        this.gameWorld = gameWorld;
        camera = new OrthographicCamera();
        camera.setToOrtho(true, 137, 204);

        batcher = new SpriteBatch();
        batcher.setProjectionMatrix(camera.combined);

        this.midPointY = midPointY;
        this.gameHeight = gameHeight;

        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(camera.combined);

        initAssets();
        initGameObjects();

    }

    public void render(float runTime) {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        // Draw Background color
        shapeRenderer.setColor(55 / 255.0f, 80 / 255.0f, 100 / 255.0f, 1);
        shapeRenderer.rect(0, 0, 136, midPointY + 66);

        // Draw Grass
        shapeRenderer.setColor(111 / 255.0f, 186 / 255.0f, 45 / 255.0f, 1);
        shapeRenderer.rect(0, midPointY + 66, 136, 11);

        // Draw Dirt
        shapeRenderer.setColor(147 / 255.0f, 80 / 255.0f, 27 / 255.0f, 1);
        shapeRenderer.rect(0, midPointY + 77, 136, 52);

        shapeRenderer.end();

        batcher.begin();
        batcher.disableBlending();
        batcher.draw(bg, 0, midPointY + 23, 136, 43);

        batcher.enableBlending();
        if (bird.shouldntFlap()) {
            batcher.draw(birdMid, bird.getX(), bird.getY(), bird.getWidth() / 2.0f, bird.getHeight() / 2.0f, bird.getWidth(), bird.getHeight(), 1, 1, bird.getRotation());
        } else {
            batcher.draw(birdAnimation.getKeyFrame(runTime), bird.getX(), bird.getY(), bird.getWidth() / 2.0f, bird.getHeight() / 2.0f, bird.getWidth(), bird.getHeight(), 1, 1, bird.getRotation());
        }
        batcher.end();

    }
}
