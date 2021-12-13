package com.github.catsoftware.vc.graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Texture {

    private int width;
    private int height;
    private BufferedImage bufferedImage;

    public Texture(String path, int width, int height) {
        try {
            bufferedImage = ImageIO.read(new File(path));
            this.width = width;
            this.height = height;
        } catch (IOException ignored) {
            ignored.printStackTrace();
        }
    }

    public BufferedImage crop(int posX, int posY, int width, int height) {
        return bufferedImage.getSubimage(posX, posY, width, height);
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
