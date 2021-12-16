package com.github.catsoftware.vc.objects.table;

import com.github.catsoftware.engine.graphics.TextureRegion;
import com.github.catsoftware.engine.physics.BoxCollision;
import com.github.catsoftware.engine.tiles.CollidableTile;
import com.github.catsoftware.vc.utils.Loader;

public class TableLeftDownCorner extends CollidableTile {

    public static final int TALBLE_LEFT_DOWN_CORNER_ID = 186;
    private static final TextureRegion textureRegion = new TextureRegion(16, 64, 16, 16, Loader.DEFAULT_TEXTURE);

    public TableLeftDownCorner(int posX, int posY, int width, int height) {
        super(TALBLE_LEFT_DOWN_CORNER_ID, textureRegion, posX, posY, width, height);
    }

    @Override
    public BoxCollision getBoxCollision() {
        if (boxCollision == null)
            boxCollision = new BoxCollision((posX * width) + offsetX, (posY * height) + offsetY, width, 11);
        return boxCollision;
    }
}
