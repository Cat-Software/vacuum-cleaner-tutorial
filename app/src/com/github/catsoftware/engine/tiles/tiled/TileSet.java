package com.github.catsoftware.engine.tiles.tiled;

public class TileSet {

    private int firstGid;
    private String source;

    public TileSet() {
    }

    public TileSet(int firstGid, String source) {
        this.firstGid = firstGid;
        this.source = source;
    }

    public int getFirstGid() {
        return firstGid;
    }

    public void setFirstGid(int firstGid) {
        this.firstGid = firstGid;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "TileSet{" +
                "firstGid=" + firstGid +
                ", source='" + source + '\'' +
                '}';
    }
}
