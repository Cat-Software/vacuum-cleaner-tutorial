package com.github.catsoftware.vc.commands.vacuumcleaner;

import com.github.catsoftware.vc.entities.VacuumCleanerRenderEntity;
import com.github.catsoftware.vc.enums.Direction;
import com.github.catsoftware.vc.models.VacuumCleanerModel;

public final class MoveLeftCommand extends VacuumCleanerCommand {

    public MoveLeftCommand(
            VacuumCleanerModel vacuumCleanerModel,
            VacuumCleanerRenderEntity vacuumCleanerRenderEntity
    ) {
        super(vacuumCleanerModel, vacuumCleanerRenderEntity);
    }

    @Override
    public void execute(double deltaTime) {
        vacuumCleanerModel.setDirection(Direction.LEFT);
        vacuumCleanerRenderEntity.setDirection(vacuumCleanerModel.getDirection());

        if (vacuumCleanerModel.hasCollision() && vacuumCleanerModel.getCollisionDirection() == Direction.LEFT) return;
        vacuumCleanerRenderEntity.setPosX(
                (int) (vacuumCleanerRenderEntity.getPosX() + (((vacuumCleanerModel.getVelocity() - 60) * -1) * deltaTime))
        );
        vacuumCleanerModel.setCollision(false);
    }
}
