package com.github.catsoftware.vc.objects.chairs.front;

import com.github.catsoftware.engine.graphics.TextureRegion;
import com.github.catsoftware.engine.tiles.Tile;
import com.github.catsoftware.vc.utils.Loader;

public class ChairDownFront extends Tile {

    public static final int CHAIR_DOWN_FRONT_ID = 277;
    private static final TextureRegion textureRegion = new TextureRegion(0, 96, 16, 16, Loader.DEFAULT_TEXTURE);

    public ChairDownFront(int posX, int posY, int width, int height) {
        super(CHAIR_DOWN_FRONT_ID, textureRegion, posX, posY, width, height);
    }
}
