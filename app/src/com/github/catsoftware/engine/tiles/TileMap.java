package com.github.catsoftware.engine.tiles;

import com.github.catsoftware.vc.objects.FloorTile;
import com.github.catsoftware.vc.objects.WallFooterTile;
import com.github.catsoftware.vc.objects.WallUpperTile;

import java.awt.*;
import java.lang.reflect.Constructor;
import java.util.List;

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

    public void test(List<String> classes) {
        for (String c : classes) {
            System.out.println(c);
        }
    }


    public void load(List<String> tileNames) {
        for (int layerIndex = 0; layerIndex < totalLayers; layerIndex++) {
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int tileId = data[layerIndex][y][x];

                    try {
                        for (String c : tileNames) {
                            Class<?> aClass = Class.forName(c);
                            Constructor<?> constructor = aClass.getDeclaredConstructor(Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
                            Object tile = constructor.newInstance(x, y, tileSize, tileSize);

                            if (tile instanceof Tile) {
                                if (tileId == ((Tile) tile).getId()) {
                                    tiles[layerIndex][x + y * width] = (Tile) tile;
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
}
