package com.github.catsoftware.engine.tiles.tiled;

import java.util.Arrays;

public class Layer {
    private int id;
    private String name;
    private int width;
    private int height;
    private int offsetx;
    private int offsety;

    private int data[];

    public Layer() {}

    public Layer(int id, String name, int width, int height) {
        this.id = id;
        this.name = name;
        this.width = width;
        this.height = height;
    }

    public Layer(int id, String name, int width, int height, int offsetx, int offsety) {
        this.id = id;
        this.name = name;
        this.width = width;
        this.height = height;
        this.offsetx = offsetx;
        this.offsety = offsety;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }

    public int getOffsetx() {
        return offsetx;
    }

    public void setOffsetx(int offsetx) {
        this.offsetx = offsetx;
    }

    public int getOffsety() {
        return offsety;
    }

    public void setOffsety(int offsety) {
        this.offsety = offsety;
    }

    @Override
    public String toString() {
        return "Layer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}
