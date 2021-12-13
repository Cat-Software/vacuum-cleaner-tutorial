package com.github.catsoftware.vc.graphics;

import java.awt.*;
import java.awt.image.BufferedImage;

public class TextureRegion {

    private int posX;
    private int posY;
    private int width;
    private int height;
    
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
        return image.getScaledInstance(width * scaleFactor, height * scaleFactor, Image.SCALE_DEFAULT);
    }
}
