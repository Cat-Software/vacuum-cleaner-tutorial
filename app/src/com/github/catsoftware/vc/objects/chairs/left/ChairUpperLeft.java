package com.github.catsoftware.vc.objects.chairs.left;

import com.github.catsoftware.engine.graphics.TextureRegion;
import com.github.catsoftware.engine.tiles.Tile;
import com.github.catsoftware.vc.utils.Loader;

public class ChairUpperLeft extends Tile {

    public static final int CHAIR_UPPER_LEFT_ID = 233;
    private static final TextureRegion textureRegion = new TextureRegion(32, 80, 16, 16, Loader.DEFAULT_TEXTURE);

    public ChairUpperLeft(int posX, int posY, int width, int height) {
        super(CHAIR_UPPER_LEFT_ID, textureRegion, posX, posY, width, height);
    }
}
