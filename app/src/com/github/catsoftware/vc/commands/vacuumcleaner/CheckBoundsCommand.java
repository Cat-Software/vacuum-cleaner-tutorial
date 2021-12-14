package com.github.catsoftware.vc.commands.vacuumcleaner;

import com.github.catsoftware.vc.entities.VacuumCleanerRenderEntity;
import com.github.catsoftware.vc.enums.Direction;
import com.github.catsoftware.vc.models.VacuumCleanerModel;

public final class CheckBoundsCommand extends VacuumCleanerCommand {

    private int xMin;
    private int yMin;
    private int xBound;
    private int yBound;

    public CheckBoundsCommand(
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
        if (vacuumCleanerRenderEntity.getPosX() < xMin && vacuumCleanerModel.getDirection() == Direction.LEFT)
            vacuumCleanerModel.setCollision(true);
        else if (vacuumCleanerRenderEntity.getPosX() + vacuumCleanerRenderEntity.getWidth() >= xBound && vacuumCleanerModel.getDirection() == Direction.RIGHT)
            vacuumCleanerModel.setCollision(true);
        else if (vacuumCleanerRenderEntity.getPosY() < yMin && vacuumCleanerModel.getDirection() == Direction.UPPER)
            vacuumCleanerModel.setCollision(true);
        else if (vacuumCleanerRenderEntity.getPosY() + vacuumCleanerRenderEntity.getHeight() >= yBound && vacuumCleanerModel.getDirection() == Direction.DOWN)
            vacuumCleanerModel.setCollision(true);
    }
}
