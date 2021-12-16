package com.github.catsoftware.engine.physics;

import com.github.catsoftware.vc.enums.Direction;

import java.awt.*;

public class BoxCollision implements Collision<Rectangle> {
    private Rectangle rectangle;
    private Direction collisionDirection;

    public BoxCollision(int posX, int posY, int width, int height) {
        this.rectangle = new Rectangle(posX, posY, width, height);
    }

    public void setValues(int posX, int posY) {
        this.rectangle.setLocation(posX, posY);
    }

    public void setDimension(int widht, int height) {
        rectangle.width = widht;
        rectangle.height = height;
    }

    public void setWidth(int width) {
        rectangle.width = width;
    }

    public void setHeight(int height) {
        rectangle.height = height;
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
        return rectangle.contains(shape);
    }

    @Override
    public boolean isIntersected(Rectangle shape) {
        boolean hasCollision = rectangle.intersects(shape);
        if (hasCollision) {
            boolean leftSide = (rectangle.x < shape.x) && rectangle.y < shape.y + shape.height - 1 && rectangle.y + rectangle.height > shape.y + 1;
            boolean rightSide = (rectangle.x > shape.x) && rectangle.y < shape.y + shape.height - 1 && rectangle.y + rectangle.height > shape.y + 1;
            boolean topSide = (rectangle.y < shape.y) && rectangle.x < shape.x + shape.width - 1 && rectangle.x + rectangle.width > shape.x + 1;
            boolean downSide = (rectangle.y > shape.y) && rectangle.x < shape.x + shape.width - 1 && rectangle.x + rectangle.width > shape.x + 1;

            if (topSide) {
                collisionDirection = Direction.DOWN;
            } else if (downSide) {
                collisionDirection = Direction.UPPER;
            } else if (leftSide) {
                collisionDirection = Direction.RIGHT;
            } else if (rightSide) {
                collisionDirection = Direction.LEFT;
            }
        }

        return hasCollision;
    }

    public Direction getCollisionDirection() {
        return collisionDirection;
    }

    @Override
    public String toString() {
        return "BoxCollision{" +
                "rectangle=" + rectangle +
                ", collisionDirection=" + collisionDirection +
                '}';
    }

    public int getPosX() {
        return rectangle.x;
    }

    public int getPosY() {
        return rectangle.y;
    }
}
