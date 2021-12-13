package com.github.catsoftware.engine.graphics;

import java.awt.*;

public abstract class RenderEntity implements Renderable {

    private int posX;
    private int posY;
    private int width;
    private int height;
    protected TextureRegion textureRegion;

    public RenderEntity(int posX, int posY, int width, int height) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
    }

    public void setPositions(int posX, int posY) {
        setPosX(posX);
        setPosY(posY);
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

    public TextureRegion getTextureRegion() {
        return textureRegion;
    }

    public void setTextureRegion(TextureRegion textureRegion) {
        this.textureRegion = textureRegion;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(textureRegion.getTexture(4), posX, posY, null);
    }
}
