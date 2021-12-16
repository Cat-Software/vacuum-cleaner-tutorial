package com.github.catsoftware.vc.commands.vacuumcleaner;

import com.github.catsoftware.vc.entities.VacuumCleanerRenderEntity;
import com.github.catsoftware.vc.enums.Direction;
import com.github.catsoftware.vc.models.VacuumCleanerModel;

public final class MoveUpperCommand extends VacuumCleanerCommand {

    public MoveUpperCommand(
            VacuumCleanerModel vacuumCleanerModel,
            VacuumCleanerRenderEntity vacuumCleanerRenderEntity
    ) {
        super(vacuumCleanerModel, vacuumCleanerRenderEntity);
    }

    @Override
    public void execute(double deltaTime) {
        vacuumCleanerModel.setDirection(Direction.UPPER);
        vacuumCleanerRenderEntity.setDirection(vacuumCleanerModel.getDirection());
        if (vacuumCleanerModel.hasCollision() && vacuumCleanerModel.getCollisionDirection() == Direction.UPPER) return;
        vacuumCleanerRenderEntity.setPosY(
                (int) (vacuumCleanerRenderEntity.getPosY() + (((vacuumCleanerModel.getVelocity() - 60) * -1) * deltaTime))
        );
    }
}
