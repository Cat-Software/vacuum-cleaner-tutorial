package com.github.catsoftware.vc.commands.vacuumcleaner;

import com.github.catsoftware.vc.entities.VacuumCleanerRenderEntity;
import com.github.catsoftware.vc.enums.Direction;
import com.github.catsoftware.vc.models.VacuumCleanerModel;

public final class MoveRightCommand extends VacuumCleanerCommand {

    public MoveRightCommand(
            VacuumCleanerModel vacuumCleanerModel,
            VacuumCleanerRenderEntity vacuumCleanerRenderEntity
    ) {
        super(vacuumCleanerModel, vacuumCleanerRenderEntity);
    }

    @Override
    public void execute(double deltaTime) {
        vacuumCleanerModel.setDirection(Direction.RIGHT);
        vacuumCleanerRenderEntity.setDirection(vacuumCleanerModel.getDirection());
        if (vacuumCleanerModel.hasCollision() && vacuumCleanerModel.getCollisionDirection() == Direction.RIGHT) return;
        vacuumCleanerRenderEntity.setPosX(
                (int) (vacuumCleanerRenderEntity.getPosX() + (vacuumCleanerModel.getVelocity()) * deltaTime)
        );
        vacuumCleanerModel.setCollision(false);
    }
}
