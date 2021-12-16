package com.github.catsoftware.engine.tiles;

import com.github.catsoftware.engine.graphics.TextureRegion;
import com.github.catsoftware.engine.physics.BoxCollision;

import java.awt.*;

public abstract class CollidableTile extends Tile {

    protected BoxCollision boxCollision;

    public CollidableTile(int id, TextureRegion textureRegion, int posX, int posY, int width, int height) {
        super(id, textureRegion, posX, posY, width, height);
    }

    public boolean isCollidable() {
        return true;
    }

    public BoxCollision getBoxCollision() {
        if (boxCollision == null)
            boxCollision = new BoxCollision((posX * width) + offsetX, (posY * height) + offsetY, width, height);
        return boxCollision;
    }

    @Override
    public void render(Graphics graphics) {
        super.render(graphics);
        graphics.setColor(Color.magenta);
        graphics.drawRect(
                getBoxCollision().getCollisionShape().x,
                getBoxCollision().getCollisionShape().y,
                getBoxCollision().getCollisionShape().width,
                getBoxCollision().getCollisionShape().height
        );
    }
}
