package com.github.catsoftware.engine.graphics;

import java.awt.*;

public class TextureRegion {

    private int posX;
    private int posY;
    private int width;
    private int height;

    private int scaleFactor = 1;

    private Image image;

    public TextureRegion(int posX, int posY, int width, int height, Texture texture) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;

        image = texture.crop(posX, posY, width, height);
    }

    public Image getTexture() {
        return image;
    }

    public Image getTexture(int scaleFactor) {
        setScaleFactor(scaleFactor);
        return image.getScaledInstance(width * scaleFactor, height * scaleFactor, Image.SCALE_DEFAULT);
    }

    public void setScaleFactor(int scaleFactor) {
        this.scaleFactor = scaleFactor;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getWidth() {
        return width * scaleFactor;
    }

    public int getHeight() {
        return height * scaleFactor;
    }
}
