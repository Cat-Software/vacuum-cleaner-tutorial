package com.github.catsoftware.engine.graphics;

import java.awt.Graphics;

public interface Renderable {
    void update();
    void render(Graphics graphics);
}
