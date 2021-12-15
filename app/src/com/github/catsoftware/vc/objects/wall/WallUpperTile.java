package com.github.catsoftware.vc.objects.wall;

import com.github.catsoftware.engine.graphics.TextureRegion;
import com.github.catsoftware.engine.tiles.Tile;
import com.github.catsoftware.vc.utils.Loader;

public class WallUpperTile extends Tile {

    public static final int WALL_UPPER_TILE_ID = 1;
    private static final TextureRegion textureRegion = new TextureRegion(0, 0, 16, 16, Loader.DEFAULT_TEXTURE);

    public WallUpperTile(int posX, int posY, int width, int height) {
        super(WALL_UPPER_TILE_ID, textureRegion, posX, posY, width, height);
    }
}
