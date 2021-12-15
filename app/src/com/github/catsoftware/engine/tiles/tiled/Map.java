package com.github.catsoftware.engine.tiles.tiled;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private int width;
    private int height;
    private int tilewidth;
    private int tileheight;

    private TileSet tileSet;
    private List<Layer> layers = new ArrayList<>();

    public Map() {
    }

    public Map(int width, int height, int tilewidth, int tileheight) {
        this.width = width;
        this.height = height;
        this.tilewidth = tilewidth;
        this.tileheight = tileheight;
    }

    public void addLayer(Layer layer) {
        layers.add(layer);
    }

    public void setTileSet(TileSet tileSet) {
        this.tileSet = tileSet;
    }

    public TileSet getTileSet() {
        return tileSet;
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

    public int getTilewidth() {
        return tilewidth;
    }

    public void setTilewidth(int tilewidth) {
        this.tilewidth = tilewidth;
    }

    public int getTileheight() {
        return tileheight;
    }

    public void setTileheight(int tileheight) {
        this.tileheight = tileheight;
    }

    public int getTotalLayers() {
        return layers.size();
    }

    public List<Layer> getLayers() {
        return List.copyOf(layers);
    }

    @Override
    public String toString() {
        return "Map{" +
                "width=" + width +
                ", height=" + height +
                ", tilewidth=" + tilewidth +
                ", tileheight=" + tileheight +
                ", tileSet=" + tileSet +
                ", layers=" + layers +
                '}';
    }
}
