package com.github.catsoftware.vc.objects.plant;

import com.github.catsoftware.engine.graphics.TextureRegion;
import com.github.catsoftware.engine.tiles.Tile;
import com.github.catsoftware.vc.utils.Loader;

public class PlantDown extends Tile {
    private static final int PLANT_DOWN_ID = 50;
    private static final TextureRegion textureRegion = new TextureRegion(48, 16, 16, 16, Loader.DEFAULT_TEXTURE);

    public PlantDown(int posX, int posY, int width, int height) {
        super(PLANT_DOWN_ID, textureRegion, posX, posY, width, height);
    }
}
