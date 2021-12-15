package com.github.catsoftware.vc.objects.chairs.right;

import com.github.catsoftware.engine.graphics.TextureRegion;
import com.github.catsoftware.engine.tiles.Tile;
import com.github.catsoftware.vc.utils.Loader;

public class ChairUpperRight extends Tile {

    public static final int CHAIR_UPPER_RIHGT_ID = 232;
    private static final TextureRegion textureRegion = new TextureRegion(16, 80, 16, 16, Loader.DEFAULT_TEXTURE);

    public ChairUpperRight(int posX, int posY, int width, int height) {
        super(CHAIR_UPPER_RIHGT_ID, textureRegion, posX, posY, width, height);
    }
}
