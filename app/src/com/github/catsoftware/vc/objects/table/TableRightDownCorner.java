package com.github.catsoftware.vc.objects.table;

import com.github.catsoftware.engine.graphics.TextureRegion;
import com.github.catsoftware.engine.tiles.Tile;
import com.github.catsoftware.vc.utils.Loader;

public class TableRightDownCorner extends Tile {

    public static final int TALBLE_RIGHT_DOWN_CORNER_ID = 187;
    private static final TextureRegion textureRegion = new TextureRegion(32, 64, 16, 16, Loader.DEFAULT_TEXTURE);

    public TableRightDownCorner(int posX, int posY, int width, int height) {
        super(TALBLE_RIGHT_DOWN_CORNER_ID, textureRegion, posX, posY, width, height);
    }
}
