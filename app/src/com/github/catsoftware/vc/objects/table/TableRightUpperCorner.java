package com.github.catsoftware.vc.objects.table;

import com.github.catsoftware.engine.graphics.TextureRegion;
import com.github.catsoftware.engine.tiles.Tile;
import com.github.catsoftware.vc.utils.Loader;

public class TableRightUpperCorner extends Tile {

    public static final int TALBLE_RIGHT_UPPER_CORNER_ID = 141;
    private static final TextureRegion textureRegion = new TextureRegion(32, 48, 16, 16, Loader.DEFAULT_TEXTURE);

    public TableRightUpperCorner(int posX, int posY, int width, int height) {
        super(TALBLE_RIGHT_UPPER_CORNER_ID, textureRegion, posX, posY, width, height);
    }
}
