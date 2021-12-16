package com.github.catsoftware.vc.commands.vacuumcleaner;

import com.github.catsoftware.vc.entities.VacuumCleanerRenderEntity;
import com.github.catsoftware.vc.models.VacuumCleanerModel;

public final class MoveCommand extends VacuumCleanerCommand {

    private final MoveLeftCommand moveLeftCommand;
    private final MoveRightCommand moveRightCommand;
    private final MoveUpperCommand moveUpperCommand;
    private final MoveDownCommand moveDownCommand;

    public MoveCommand(
            VacuumCleanerModel vacuumCleanerModel,
            VacuumCleanerRenderEntity vacuumCleanerRenderEntity
    ) {
        super(vacuumCleanerModel, vacuumCleanerRenderEntity);

        this.moveLeftCommand = new MoveLeftCommand(vacuumCleanerModel, vacuumCleanerRenderEntity);
        this.moveRightCommand = new MoveRightCommand(vacuumCleanerModel, vacuumCleanerRenderEntity);
        this.moveDownCommand = new MoveDownCommand(vacuumCleanerModel, vacuumCleanerRenderEntity);
        this.moveUpperCommand = new MoveUpperCommand(vacuumCleanerModel, vacuumCleanerRenderEntity);
    }

    @Override
    public void execute(double deltaTime) {
        switch (vacuumCleanerModel.getDirection()) {
            case LEFT:
                moveLeftCommand.execute(deltaTime);
                break;
            case RIGHT:
                moveRightCommand.execute(deltaTime);
                break;
            case UPPER:
                moveUpperCommand.execute(deltaTime);
                break;
            case DOWN:
                moveDownCommand.execute(deltaTime);
                break;
        }
    }
}
