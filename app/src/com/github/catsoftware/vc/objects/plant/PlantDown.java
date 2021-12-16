package com.github.catsoftware.vc.objects.plant;

import com.github.catsoftware.engine.graphics.TextureRegion;
import com.github.catsoftware.engine.physics.BoxCollision;
import com.github.catsoftware.engine.tiles.CollidableTile;
import com.github.catsoftware.vc.utils.Loader;

public class PlantDown extends CollidableTile {
    private static final int PLANT_DOWN_ID = 50;
    private static final TextureRegion textureRegion = new TextureRegion(48, 16, 16, 16, Loader.DEFAULT_TEXTURE);

    public PlantDown(int posX, int posY, int width, int height) {
        super(PLANT_DOWN_ID, textureRegion, posX, posY, width, height);
    }

    @Override
    public BoxCollision getBoxCollision() {
        if (boxCollision == null)
            boxCollision = new BoxCollision((posX * width) + offsetX + 2, (posY * height) + offsetY, 12, 9);

        return boxCollision;
    }
}
