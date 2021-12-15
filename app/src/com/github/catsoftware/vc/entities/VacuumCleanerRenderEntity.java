package com.github.catsoftware.vc.entities;

import com.github.catsoftware.engine.graphics.RenderEntity;
import com.github.catsoftware.engine.graphics.TextureRegion;
import com.github.catsoftware.engine.physics.BoxCollision;
import com.github.catsoftware.vc.enums.Direction;
import com.github.catsoftware.vc.utils.Loader;

import java.awt.*;

public class VacuumCleanerRenderEntity extends RenderEntity {

    private Direction currentDirection;
    private Direction previousDirection;
    private int currentTextureIndex;

    private final BoxCollision boxCollision;
    private final BoxCollision trashDetectorCollision;

    private final TextureRegion[] textureRegions = {
            new TextureRegion(80, 48, 16, 16, Loader.DEFAULT_TEXTURE),
            new TextureRegion(80, 32, 16, 16, Loader.DEFAULT_TEXTURE),
            new TextureRegion(96, 48, 16, 16, Loader.DEFAULT_TEXTURE),
            new TextureRegion(96, 32, 16, 16, Loader.DEFAULT_TEXTURE),
    };

    public VacuumCleanerRenderEntity(int posX, int posY, int width, int height, Direction direction) {
        super(posX, posY, width, height);
        currentDirection = direction;
        previousDirection = direction;
        currentTextureIndex = direction.ordinal();
        setTextureRegion(textureRegions[currentTextureIndex]);

        boxCollision = new BoxCollision(posX, posY, width, height);
        trashDetectorCollision = new BoxCollision(posX, posY, width * 4, height * 4);
    }

    public void setDirection(Direction direction) {
        previousDirection = currentDirection;
        currentDirection = direction;
        currentTextureIndex = direction.ordinal();
    }

    public Direction getPreviousDirection() {
        return previousDirection;
    }

    @Override
    public void update() {
        if(currentDirection != previousDirection)
            setTextureRegion(textureRegions[currentTextureIndex]);

        boxCollision.setValues(getPosX(), getPosY());
        trashDetectorCollision.setValues(
                getPosX() - (trashDetectorCollision.getCollisionShape().width / 2) + getWidth() / 2,
                getPosY() - (trashDetectorCollision.getCollisionShape().height / 2) + getHeight() / 2
        );
    }

    @Override
    public void render(Graphics graphics) {
        super.render(graphics);

        graphics.setColor(Color.RED);
        boxCollision.render(graphics);

        graphics.setColor(Color.GREEN);
        trashDetectorCollision.render(graphics);
    }
}
