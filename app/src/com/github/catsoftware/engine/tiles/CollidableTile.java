package com.github.catsoftware.engine.tiles;

import com.github.catsoftware.engine.graphics.TextureRegion;
import com.github.catsoftware.engine.physics.BoxCollision;

public abstract class CollidableTile extends Tile {

    private BoxCollision boxCollision;

    public CollidableTile(int id, TextureRegion textureRegion, int posX, int posY, int width, int height) {
        super(id, textureRegion, posX, posY, width, height);
        boxCollision = new BoxCollision(posX + getOffsetX(), posY + getOffsetY(), width, height);
    }

    public boolean isCollidable() {
        return true;
    }

    public BoxCollision getBoxCollision() {
        return boxCollision;
    }
}
