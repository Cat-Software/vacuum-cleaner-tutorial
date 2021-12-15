package com.github.catsoftware.vc.objects.plant;

import com.github.catsoftware.engine.graphics.TextureRegion;
import com.github.catsoftware.engine.tiles.Tile;
import com.github.catsoftware.vc.utils.Loader;

public class PlantUpper extends Tile {
    private static final int PLANT_UPPER_ID = 4;
    private static final TextureRegion textureRegion = new TextureRegion(48, 0, 16, 16, Loader.DEFAULT_TEXTURE);

    public PlantUpper(int posX, int posY, int width, int height) {
        super(PLANT_UPPER_ID, textureRegion, posX, posY, width, height);
    }
}
