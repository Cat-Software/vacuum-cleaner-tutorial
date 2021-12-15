package com.github.catsoftware.engine.physics;

import java.awt.*;

public class BoxCollision implements Collision<Rectangle> {
    private Rectangle rectangle;

    public BoxCollision(int posX, int posY, int width, int height) {
        this.rectangle = new Rectangle(posX, posY, width, height);
    }

    public void setValues(int posX, int posY) {
        this.rectangle.setLocation(posX, posY);
    }

    public void render(Graphics graphics) {
        graphics.drawRect(
                rectangle.x,
                rectangle.y,
                rectangle.width,
                rectangle.height
        );
    }

    @Override
    public Rectangle getCollisionShape() {
        return rectangle;
    }

    @Override
    public boolean isOverlap(Rectangle shape) {
        return false;
    }

    @Override
    public boolean isIntersected(Rectangle shape) {
        return false;
    }
}
