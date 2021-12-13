package com.github.catsoftware.vc.commands.vacuumcleaner;

import com.github.catsoftware.vc.entities.VacuumCleanerRenderEntity;
import com.github.catsoftware.vc.enums.Direction;
import com.github.catsoftware.vc.models.VacuumCleanerModel;

public class MoveToOppositeDirectionVacuumCleanerCommand extends VacuumCleanerCommand {
    public MoveToOppositeDirectionVacuumCleanerCommand(
            VacuumCleanerModel vacuumCleanerModel,
            VacuumCleanerRenderEntity vacuumCleanerRenderEntity
    ) {
        super(vacuumCleanerModel, vacuumCleanerRenderEntity);
    }

    @Override
    public void execute(double deltaTime) {
        if(vacuumCleanerModel.getDirection() == Direction.RIGHT)
            vacuumCleanerModel.setDirection(Direction.LEFT);
        else if(vacuumCleanerModel.getDirection() == Direction.LEFT)
            vacuumCleanerModel.setDirection(Direction.RIGHT);
        else if(vacuumCleanerModel.getDirection() == Direction.UPPER)
            vacuumCleanerModel.setDirection(Direction.DOWN);
        else if(vacuumCleanerModel.getDirection() == Direction.DOWN)
            vacuumCleanerModel.setDirection(Direction.UPPER);

    }
}
