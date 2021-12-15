package com.github.catsoftware.vc.objects.chairs.right;

import com.github.catsoftware.engine.graphics.TextureRegion;
import com.github.catsoftware.engine.tiles.Tile;
import com.github.catsoftware.vc.utils.Loader;

public class ChairDownRight extends Tile {

    public static final int CHAIR_DOWN_RIGHT_ID = 278;
    private static final TextureRegion textureRegion = new TextureRegion(32, 96, 16, 16, Loader.DEFAULT_TEXTURE);

    public ChairDownRight(int posX, int posY, int width, int height) {
        super(CHAIR_DOWN_RIGHT_ID, textureRegion, posX, posY, width, height);
    }
}
