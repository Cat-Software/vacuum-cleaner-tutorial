package com.github.catsoftware.vc.maps;

import com.github.catsoftware.vc.objects.FloorTile;
import com.github.catsoftware.engine.tiles.TileMap;
import com.github.catsoftware.vc.objects.WallFooterTile;
import com.github.catsoftware.vc.objects.WallUpperTile;

public class Room extends TileMap {
    public Room(int width, int height, int tileSize) {
        super(width, height, tileSize);
    }

    @Override
    public void load() {
        for (int layerIndex = 0; layerIndex < totalLayers; layerIndex++) {
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int tileId = data[layerIndex][y][x];
                    if (tileId == FloorTile.FLOOR_TILE_ID)
                        tiles[layerIndex][x + y * width] = new FloorTile(x, y, tileSize, tileSize);
                    if (tileId == WallUpperTile.WALL_UPPER_TILE_ID)
                        tiles[layerIndex][x + y * width] = new WallUpperTile(x, y, tileSize, tileSize);
                    if (tileId == WallFooterTile.WALL_FOOTER_TILE_ID)
                        tiles[layerIndex][x + y * width] = new WallFooterTile(x, y, tileSize, tileSize);
                }
            }
        }
    }
}
