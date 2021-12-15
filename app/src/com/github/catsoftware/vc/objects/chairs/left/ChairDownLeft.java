package com.github.catsoftware.vc.objects.chairs.left;

import com.github.catsoftware.engine.graphics.TextureRegion;
import com.github.catsoftware.engine.tiles.Tile;
import com.github.catsoftware.vc.utils.Loader;

public class ChairDownLeft extends Tile {

    public static final int CHAIR_DOWN_LEFT_ID = 279;
    private static final TextureRegion textureRegion = new TextureRegion(16, 96, 16, 16, Loader.DEFAULT_TEXTURE);

    public ChairDownLeft(int posX, int posY, int width, int height) {
        super(CHAIR_DOWN_LEFT_ID, textureRegion, posX, posY, width, height);
    }
}
