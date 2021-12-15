package com.github.catsoftware.vc.objects.chairs.back;

import com.github.catsoftware.engine.graphics.TextureRegion;
import com.github.catsoftware.engine.tiles.Tile;
import com.github.catsoftware.vc.utils.Loader;

public class ChairDownBack extends Tile {

    public static final int CHAIR_DOWN_BACK_ID = 280;
    private static final TextureRegion textureRegion = new TextureRegion(48, 96, 16, 16, Loader.DEFAULT_TEXTURE);

    public ChairDownBack(int posX, int posY, int width, int height) {
        super(CHAIR_DOWN_BACK_ID, textureRegion, posX, posY, width, height);
    }
}
