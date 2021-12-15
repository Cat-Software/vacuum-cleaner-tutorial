package com.github.catsoftware.vc.commands.vacuumcleaner;

import com.github.catsoftware.vc.entities.VacuumCleanerRenderEntity;
import com.github.catsoftware.vc.models.VacuumCleanerModel;

public final class MoveCommand extends VacuumCleanerCommand {

    public MoveCommand(
            VacuumCleanerModel vacuumCleanerModel,
            VacuumCleanerRenderEntity vacuumCleanerRenderEntity
    ) {
        super(vacuumCleanerModel, vacuumCleanerRenderEntity);
    }

    @Override
    public void execute(double deltaTime) {
        if (vacuumCleanerModel.hasCollision()) return;
        vacuumCleanerRenderEntity.setDirection(vacuumCleanerModel.getDirection());

        switch (vacuumCleanerModel.getDirection()) {
            case LEFT:
                vacuumCleanerRenderEntity.setPosX(
                        (int) (vacuumCleanerRenderEntity.getPosX() + ((vacuumCleanerModel.getVelocity() * -1) * deltaTime))
                );
                break;
            case RIGHT:
                vacuumCleanerRenderEntity.setPosX(
                        (int) (vacuumCleanerRenderEntity.getPosX() + (vacuumCleanerModel.getVelocity()) * deltaTime)
                );
                break;
            case UPPER:
                vacuumCleanerRenderEntity.setPosY(
                        (int) (vacuumCleanerRenderEntity.getPosY() + ((vacuumCleanerModel.getVelocity() * -1) * deltaTime))
                );
                break;
            case DOWN:
                vacuumCleanerRenderEntity.setPosY(
                        (int) (vacuumCleanerRenderEntity.getPosY() + (vacuumCleanerModel.getVelocity()) * deltaTime)
                );
                break;
        }
    }
}
