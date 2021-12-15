package com.github.catsoftware.vc.objects.shelf;

import com.github.catsoftware.engine.graphics.TextureRegion;
import com.github.catsoftware.engine.tiles.Tile;
import com.github.catsoftware.vc.utils.Loader;

public class ShelfUpper extends Tile {

    public static final int SHELF_UPPER_ID = 5;
    private static final TextureRegion textureRegion = new TextureRegion(64, 0, 16, 16, Loader.DEFAULT_TEXTURE);

    public ShelfUpper(int posX, int posY, int width, int height) {
        super(SHELF_UPPER_ID, textureRegion, posX, posY, width, height);
    }
}
