package com.github.catsoftware.engine.tiles;

import com.github.catsoftware.engine.graphics.RenderEntity;
import com.github.catsoftware.engine.tiles.tiled.Layer;
import com.github.catsoftware.engine.tiles.tiled.Map;

import java.awt.*;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public abstract class TileMap {

    protected int width;
    protected int height;
    protected int tileSize;
    protected int totalTiles;

    protected int totalLayers;

    protected Tile[][] tiles;
    private List<Layer> layers;

    private List<CollidableTile> collidables = new ArrayList<>();

    public TileMap(Map map, int tileSize) {
        this.tileSize = tileSize;

        width = map.getWidth();
        height = map.getHeight();

        totalLayers = map.getTotalLayers();
        layers = map.getLayers();

        totalTiles = width * height;
        tiles = new Tile[totalLayers][totalTiles];
    }

    public void load(List<String> tileNames) {
        for (int layerIndex = 0; layerIndex < totalLayers; layerIndex++) {
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int tileId = layers.get(layerIndex).getTileId(x, y);
                    int offsetX = layers.get(layerIndex).getOffsetx();
                    int offsetY = layers.get(layerIndex).getOffsety();
                    try {
                        for (String c : tileNames) {
                            Class<?> aClass = Class.forName(c);
                            Constructor<?> constructor = aClass.getDeclaredConstructor(Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
                            Object tile = constructor.newInstance(x, y, tileSize, tileSize);

                            if (tile instanceof Tile) {
                                if (tileId == ((Tile) tile).getId()) {
                                    ((Tile) tile).setOffsetX(offsetX);
                                    ((Tile) tile).setOffsetY(offsetY);
                                    tiles[layerIndex][x + y * width] = (Tile) tile;

                                    if(tile instanceof CollidableTile) {
                                        collidables.add((CollidableTile) tile);
                                    }
                                    break;
                                }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

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
                    if (tile != null) tile.render(graphics);
                }
            }
        }
    }

    public void renderOneEntityInLayer(Graphics graphics, RenderEntity renderEntity, int layerIndexToRender) {
        for (int layerIndex = 0; layerIndex < totalLayers; layerIndex++) {
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {

                    if(layerIndex == layerIndexToRender)
                        renderEntity.render(graphics);

                    Tile tile = tiles[layerIndex][x + y * width];
                    if (tile != null) tile.render(graphics);
                }
            }
        }
    }

    public List<CollidableTile> getCollidables() {
        return collidables;
    }
}
