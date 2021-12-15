package com.github.catsoftware.vc.objects.carpet;

import com.github.catsoftware.engine.graphics.TextureRegion;
import com.github.catsoftware.engine.tiles.Tile;
import com.github.catsoftware.vc.utils.Loader;

public class CarpetRightDownCorner extends Tile {

    public static final int CARPET_LEFT_UPPER_CONNER_ID = 54;
    private static final TextureRegion textureRegion = new TextureRegion(112, 16, 16, 16, Loader.DEFAULT_TEXTURE);

    public CarpetRightDownCorner(int posX, int posY, int width, int height) {
        super(CARPET_LEFT_UPPER_CONNER_ID, textureRegion, posX, posY, width, height);
    }
}
