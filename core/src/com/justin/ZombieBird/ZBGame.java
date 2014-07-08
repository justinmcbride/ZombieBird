package com.justin.ZombieBird;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.justin.ZBHelpers.AssetLoader;

public class ZBGame extends Game {
	SpriteBatch batch;
	Texture img;
	
	@Override
	public void create () {
        AssetLoader.load();
        setScreen(new GameScreen());
	}

    @Override
    public void dispose() {
        super.dispose();
        AssetLoader.dispose();
    }
}
