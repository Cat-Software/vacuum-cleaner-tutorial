package com.github.catsoftware.vc.entities;

import com.github.catsoftware.vc.enums.Direction;

import java.util.List;

public class VacuumCleaner {
    private int id;
    private Direction direction;
    private float velocity;
    private boolean hasCollision;
    private int collisionCount;
    private List<Trash> collectedTrashes;

    public VacuumCleaner(int id) {
        this.id = id;
        this.velocity = 400.0f;
        direction = Direction.RIGHT;
    }

    public VacuumCleaner(int id, Direction direction, float velocity) {
        this.id = id;
        this.direction = direction;
        this.velocity = velocity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public float getVelocity() {
        return velocity;
    }

    public void setVelocity(float velocity) {
        this.velocity = velocity;
    }

    public boolean isHasCollision() {
        return hasCollision;
    }

    public void setHasCollision(boolean hasCollision) {
        this.hasCollision = hasCollision;
    }

    public int getCollisionCount() {
        return collisionCount;
    }

    public void setCollisionCount(int collisionCount) {
        this.collisionCount = collisionCount;
    }

    public List<Trash> getCollectedTrashes() {
        return List.copyOf(collectedTrashes);
    }

    public void addTrash(Trash trash) {
        collectedTrashes.add(trash);
    }

    public int amountCollectedTrashes() {
        return collectedTrashes.size();
    }
}
