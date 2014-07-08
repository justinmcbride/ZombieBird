package com.justin.ZombieBird;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.justin.ZBHelpers.AssetHelper;

public class ZBGame extends Game {
	SpriteBatch batch;
	Texture img;
	
	@Override
	public void create () {
        AssetHelper.load();
        setScreen(new GameScreen());
	}

    @Override
    public void dispose() {
        super.dispose();
        AssetHelper.dispose();
    }
}
