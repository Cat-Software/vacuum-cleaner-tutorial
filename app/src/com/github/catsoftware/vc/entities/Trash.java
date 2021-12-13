package com.github.catsoftware.vc.entities;

public class Trash {

    private int id;
    private boolean isCollected;

    public Trash(int id, boolean isCollected) {
        this.id = id;
        this.isCollected = isCollected;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isCollected() {
        return isCollected;
    }

    public void setCollected(boolean collected) {
        isCollected = collected;
    }
}
