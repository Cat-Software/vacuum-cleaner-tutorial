package com.github.catsoftware.vc.objects.table;

import com.github.catsoftware.engine.graphics.TextureRegion;
import com.github.catsoftware.engine.tiles.Tile;
import com.github.catsoftware.vc.utils.Loader;

public class TableLeftUpperCorner extends Tile {

    public static final int TALBLE_LEFT_UPPER_CORNER_ID = 140;
    private static final TextureRegion textureRegion = new TextureRegion(16, 48, 16, 16, Loader.DEFAULT_TEXTURE);

    public TableLeftUpperCorner(int posX, int posY, int width, int height) {
        super(TALBLE_LEFT_UPPER_CORNER_ID, textureRegion, posX, posY, width, height);
    }
}
