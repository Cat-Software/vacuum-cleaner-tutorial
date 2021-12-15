package com.github.catsoftware.vc.objects.chairs.back;

import com.github.catsoftware.engine.graphics.TextureRegion;
import com.github.catsoftware.engine.tiles.Tile;
import com.github.catsoftware.vc.utils.Loader;

public class ChairUpperBack extends Tile {

    public static final int CHAIR_UPPER_BACK_ID = 234;
    private static final TextureRegion textureRegion = new TextureRegion(48, 80, 16, 16, Loader.DEFAULT_TEXTURE);

    public ChairUpperBack(int posX, int posY, int width, int height) {
        super(CHAIR_UPPER_BACK_ID, textureRegion, posX, posY, width, height);
    }
}
