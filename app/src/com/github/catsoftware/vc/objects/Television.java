package com.github.catsoftware.vc.objects;

import com.github.catsoftware.engine.graphics.TextureRegion;
import com.github.catsoftware.engine.tiles.Tile;
import com.github.catsoftware.vc.utils.Loader;

public class Television extends Tile {

    public static final int TELEVISION_ID = 139;
    private static final TextureRegion textureRegion = new TextureRegion(0, 48, 16, 16, Loader.DEFAULT_TEXTURE);

    public Television(int posX, int posY, int width, int height) {
        super(TELEVISION_ID, textureRegion, posX, posY, width, height);
    }
}
