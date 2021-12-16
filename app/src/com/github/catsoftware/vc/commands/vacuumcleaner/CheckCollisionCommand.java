package com.github.catsoftware.vc.commands.vacuumcleaner;

import com.github.catsoftware.engine.tiles.CollidableTile;
import com.github.catsoftware.vc.entities.VacuumCleanerRenderEntity;
import com.github.catsoftware.vc.models.VacuumCleanerModel;

import java.util.List;

public class CheckCollisionCommand extends VacuumCleanerCommand {
    private List<CollidableTile> collidableTiles;

    public CheckCollisionCommand(
            VacuumCleanerModel vacuumCleanerModel,
            VacuumCleanerRenderEntity vacuumCleanerRenderEntity,
            List<CollidableTile> collibaleTiles
    ) {
        super(vacuumCleanerModel, vacuumCleanerRenderEntity);
        this.collidableTiles = collibaleTiles;
    }

    @Override
    public void execute(double deltaTime) {
        vacuumCleanerModel.setCollision(false);

        for(CollidableTile collidableTile : collidableTiles) {
            if(
                vacuumCleanerRenderEntity
                        .getBoxCollision()
                        .isIntersected(collidableTile.getBoxCollision().getCollisionShape())
            ) {
                vacuumCleanerModel.setCollision(true);
                vacuumCleanerModel.setCollisionDirection(
                        vacuumCleanerRenderEntity.getBoxCollision().getCollisionDirection()
                );
            }
        }
    }
}
