package com.github.catsoftware.engine.physics;

import java.awt.*;

public interface Collision<T extends Shape> {

    boolean isOverlap(T shape);

    boolean isIntersected(T shape);

    T getCollisionShape();
}
