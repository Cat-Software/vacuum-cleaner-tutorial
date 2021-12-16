package com.github.catsoftware.vc.objects.shelf;

import com.github.catsoftware.engine.graphics.TextureRegion;
import com.github.catsoftware.engine.physics.BoxCollision;
import com.github.catsoftware.engine.tiles.CollidableTile;
import com.github.catsoftware.vc.utils.Loader;

public class ShelfDown extends CollidableTile {

    public static final int SHELF_DOWN_ID = 51;
    private static final TextureRegion textureRegion = new TextureRegion(64, 16, 16, 16, Loader.DEFAULT_TEXTURE);

    public ShelfDown(int posX, int posY, int width, int height) {
        super(SHELF_DOWN_ID, textureRegion, posX, posY, width, height);
    }

    @Override
    public BoxCollision getBoxCollision() {
        if (boxCollision == null)
            boxCollision = new BoxCollision((posX * width) + offsetX, (posY * height) + offsetY, width, 13);
        return boxCollision;
    }
}
