package com.github.catsoftware.vc.commands.vacuumcleaner;

import com.github.catsoftware.vc.entities.VacuumCleanerRenderEntity;
import com.github.catsoftware.vc.models.VacuumCleanerModel;

public final class CheckBoundsCollisionVacuumCleanerCommand extends VacuumCleanerCommand {

    private int xMin;
    private int yMin;
    private int xBound;
    private int yBound;

    public CheckBoundsCollisionVacuumCleanerCommand(
            VacuumCleanerModel vacuumCleanerModel,
            VacuumCleanerRenderEntity vacuumCleanerRenderEntity,
            int xMin,
            int yMin,
            int xBound,
            int yBound
    ) {
        super(vacuumCleanerModel, vacuumCleanerRenderEntity);
        this.xMin = xMin;
        this.yMin = yMin;
        this.xBound = xBound;
        this.yBound = yBound;
    }

    @Override
    public void execute(double deltaTime) {
        vacuumCleanerModel.setCollision(false);

        if(vacuumCleanerRenderEntity.getPosX() < xMin)
            vacuumCleanerModel.setCollision(true);
        if(vacuumCleanerRenderEntity.getPosX() + vacuumCleanerRenderEntity.getWidth() >= xBound)
            vacuumCleanerModel.setCollision(true);

        if(vacuumCleanerRenderEntity.getPosY() < yMin)
            vacuumCleanerModel.setCollision(true);
        if(vacuumCleanerRenderEntity.getPosY() + vacuumCleanerRenderEntity.getHeight() >= yBound)
            vacuumCleanerModel.setCollision(true);
    }
}
