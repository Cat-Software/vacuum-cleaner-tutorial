package com.github.catsoftware.vc.objects.table;

import com.github.catsoftware.engine.graphics.TextureRegion;
import com.github.catsoftware.engine.tiles.Tile;
import com.github.catsoftware.vc.utils.Loader;

public class TableLeftDownCorner extends Tile {

    public static final int TALBLE_LEFT_DOWN_CORNER_ID = 186;
    private static final TextureRegion textureRegion = new TextureRegion(16, 64, 16, 16, Loader.DEFAULT_TEXTURE);

    public TableLeftDownCorner(int posX, int posY, int width, int height) {
        super(TALBLE_LEFT_DOWN_CORNER_ID, textureRegion, posX, posY, width, height);
    }
}
