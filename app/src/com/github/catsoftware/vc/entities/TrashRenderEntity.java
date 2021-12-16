package com.github.catsoftware.vc.entities;

import com.github.catsoftware.engine.graphics.RenderEntity;
import com.github.catsoftware.engine.graphics.TextureRegion;
import com.github.catsoftware.engine.physics.BoxCollision;
import com.github.catsoftware.vc.utils.Loader;

import java.awt.*;

public class TrashRenderEntity extends RenderEntity {

    private final BoxCollision boxCollision;

    public TrashRenderEntity(int posX, int posY, int width, int height) {
        super(posX, posY, width, height);

        setTextureRegion(new TextureRegion(149, 117, 8, 8, Loader.DEFAULT_TEXTURE));
        boxCollision = new BoxCollision(posX - 1, posY -1, width, height);
    }

    @Override
    public void update() {
    }

    @Override
    public void render(Graphics graphics) {
        super.render(graphics);

        graphics.setColor(Color.BLUE);
        boxCollision.render(graphics);
    }
}
