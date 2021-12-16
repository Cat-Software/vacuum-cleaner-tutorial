package com.github.catsoftware.vc.objects.lamp;

import com.github.catsoftware.engine.graphics.TextureRegion;
import com.github.catsoftware.engine.physics.BoxCollision;
import com.github.catsoftware.engine.tiles.CollidableTile;
import com.github.catsoftware.vc.utils.Loader;

public class LampDown extends CollidableTile {

    private static final int LAMP_DOWN_ID = 49;
    private static final TextureRegion textureRegion = new TextureRegion(33, 16, 16, 16, Loader.DEFAULT_TEXTURE);

    public LampDown(int posX, int posY, int width, int height) {
        super(LAMP_DOWN_ID, textureRegion, posX, posY, width, height);
    }

    @Override
    public BoxCollision getBoxCollision() {
        if (boxCollision == null)
            boxCollision = new BoxCollision((posX * width) + offsetX + 2, (posY * height) + offsetY + 8, 11, 6);
        return boxCollision;
    }
}
