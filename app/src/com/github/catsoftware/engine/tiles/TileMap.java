package com.github.catsoftware.engine.tiles;

import java.awt.*;

public abstract class TileMap {

    protected int width;
    protected int height;
    protected int tileSize;
    protected int totalTiles;

    protected int totalLayers;

    protected Tile[][] tiles;

    protected int[][][] data;

    public TileMap(int width, int height, int tileSize) {
        this.width = width;
        this.height = height;
        this.tileSize = tileSize;

        totalTiles = width * height;
        totalLayers = 0;


    }

    public void setData(int[][][] data) {
        this.data = data;
        totalLayers = data.length;
        tiles = new Tile[totalLayers][totalTiles];
    }

    public abstract void load();

    /**
     * Renderizacao do tilemap
     *
     * @param graphics java.awt.Graphics
     */
    public void render(Graphics graphics) {
        for (int layerIndex = 0; layerIndex < totalLayers; layerIndex++) {
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    Tile tile = tiles[layerIndex][x + y * width];
                    if(tile != null) tile.render(graphics);
                }
            }
        }
    }
}
