package com.github.catsoftware.vc.commands.vacuumcleaner;

import com.github.catsoftware.vc.entities.VacuumCleanerRenderEntity;
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
        if (vacuumCleanerModel.hasCollision()) return;
        vacuumCleanerRenderEntity.setPosX(
                (int) (vacuumCleanerRenderEntity.getPosX() + (((vacuumCleanerModel.getVelocity() - 60) * -1) * deltaTime))
        );
    }
}
