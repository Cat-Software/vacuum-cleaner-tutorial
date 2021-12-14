package com.github.catsoftware.vc.objects;

import com.github.catsoftware.engine.graphics.TextureRegion;
import com.github.catsoftware.engine.tiles.Tile;
import com.github.catsoftware.vc.utils.Loader;

public class WallFooterTile extends Tile {

    public static final int WALL_FOOTER_TILE_ID = 47;
    private static final TextureRegion textureRegion = new TextureRegion(0, 16, 16, 16, Loader.DEFAULT_TEXTURE);

    public WallFooterTile(int posX, int posY, int width, int height) {
        super(WALL_FOOTER_TILE_ID, textureRegion, posX, posY, width, height);
    }
}
