package com.github.catsoftware.vc.objects;

import com.github.catsoftware.engine.graphics.TextureRegion;
import com.github.catsoftware.engine.tiles.CollidableTile;
import com.github.catsoftware.vc.utils.Loader;

public class MiniTable extends CollidableTile {

    public static final int MINI_TABLE_ID = 94;
    private static final TextureRegion textureRegion = new TextureRegion(16, 32, 16, 16, Loader.DEFAULT_TEXTURE);

    public MiniTable(int posX, int posY, int width, int height) {
        super(MINI_TABLE_ID, textureRegion, posX, posY, width, height);
    }
}
