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
        if(vacuumCleanerModel.hasCollision()) return;

        vacuumCleanerRenderEntity.setDirection(vacuumCleanerModel.getDirection());

        switch (vacuumCleanerModel.getDirection()) {
            case LEFT:
                vacuumCleanerRenderEntity.setPositions(
                        (int) (vacuumCleanerRenderEntity.getPosX() + (vacuumCleanerModel.getVelocity() * -1) * deltaTime * 1.23f),
                        vacuumCleanerRenderEntity.getPosY()
                );
                break;
            case RIGHT:
                vacuumCleanerRenderEntity.setPositions(
                        (int) (vacuumCleanerRenderEntity.getPosX() + (vacuumCleanerModel.getVelocity()) * deltaTime * 1.23f),
                        vacuumCleanerRenderEntity.getPosY()
                );
                break;
            case UPPER:
                vacuumCleanerRenderEntity.setPositions(
                        vacuumCleanerRenderEntity.getPosX(),
                        (int) (vacuumCleanerRenderEntity.getPosY() + (vacuumCleanerModel.getVelocity() * -1) * deltaTime * 1.23f)
                );
                break;
            case DOWN:
                vacuumCleanerRenderEntity.setPositions(
                        vacuumCleanerRenderEntity.getPosX(),
                        (int) (vacuumCleanerRenderEntity.getPosY() + (vacuumCleanerModel.getVelocity()) * deltaTime * 1.23f)
                );
                break;
        }
    }
}
