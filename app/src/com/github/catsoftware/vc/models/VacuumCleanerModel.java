package com.github.catsoftware.vc.models;

import com.github.catsoftware.vc.enums.Direction;

import java.util.List;

public class VacuumCleanerModel {
    private int id;
    private Direction direction;
    private float velocity;
    private boolean hasCollision;
    private int collisionCount;
    private List<TrashModel> collectedTrashModels;

    public VacuumCleanerModel(int id) {
        this.id = id;
        this.velocity = 400.0f;
        direction = Direction.RIGHT;
    }

    public VacuumCleanerModel(int id, Direction direction, float velocity) {
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

    public boolean hasCollision() {
        return hasCollision;
    }

    public void setCollision(boolean hasCollision) {
        this.hasCollision = hasCollision;
    }

    public int getCollisionCount() {
        return collisionCount;
    }

    public void setCollisionCount(int collisionCount) {
        this.collisionCount = collisionCount;
    }

    public List<TrashModel> getCollectedTrashes() {
        return List.copyOf(collectedTrashModels);
    }

    public void addTrash(TrashModel trashModel) {
        collectedTrashModels.add(trashModel);
    }

    public int amountCollectedTrashes() {
        return collectedTrashModels.size();
    }
}
