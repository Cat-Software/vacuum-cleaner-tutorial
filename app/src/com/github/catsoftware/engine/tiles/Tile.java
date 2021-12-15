package com.github.catsoftware.engine.tiles;

import com.github.catsoftware.engine.graphics.TextureRegion;

import java.awt.*;

public abstract class Tile {

    private final int id;
    private final TextureRegion textureRegion;

    protected int posX;
    protected int posY;
    protected int width;
    protected int height;

    protected int offsetX;
    protected int offsetY;

    public Tile(int id, TextureRegion textureRegion, int posX, int posY, int width, int height) {
        this.id = id;
        this.textureRegion = textureRegion;
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
    }

    /**
     * Renderiza o Tile
     *
     * @param graphics Java.awt.Graphics
     */
    public void render(Graphics graphics) {
        graphics.drawImage(textureRegion.getTexture(), (posX * width) + offsetX, (posY * height) + offsetY, null);
    }

    public void update(double deltaTime) {
    }

    public int getId() {
        return id;
    }

    public TextureRegion getTextureRegion() {
        return textureRegion;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getOffsetX() {
        return offsetX;
    }

    public void setOffsetX(int offsetX) {
        this.offsetX = offsetX;
    }

    public int getOffsetY() {
        return offsetY;
    }

    public void setOffsetY(int offsetY) {
        this.offsetY = offsetY;
    }
}
