package com.github.catsoftware.vc.objects;

import com.github.catsoftware.engine.graphics.TextureRegion;
import com.github.catsoftware.engine.tiles.Tile;
import com.github.catsoftware.vc.utils.Loader;

public class FloorTile extends Tile {

    public static final int FLOOR_TILE_ID = 93;
    private static final TextureRegion textureRegion = new TextureRegion(0, 32, 16, 16, Loader.DEFAULT_TEXTURE);

    public FloorTile(int posX, int posY, int width, int height) {
        super(FLOOR_TILE_ID, textureRegion, posX, posY, width, height);
    }
}
