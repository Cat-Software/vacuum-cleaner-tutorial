package com.github.catsoftware.vc.commands.vacuumcleaner;

import java.util.ArrayList;
import java.util.List;

public class VacuumCleanerCommandPool {
    private List<VacuumCleanerCommand> vacuumCleanerCommands = new ArrayList<>();

    /**
     *
     * @param vacuumCleanerCommand
     * @param priority 0 -> maior prioridade ...
     */
    public void addCommand(VacuumCleanerCommand vacuumCleanerCommand, int priority) {
        vacuumCleanerCommands.add(priority, vacuumCleanerCommand);
    }

    public void addCommand(VacuumCleanerCommand vacuumCleanerCommand) {
        vacuumCleanerCommands.add(vacuumCleanerCommand);
    }

    public void applyCommands(double deltaTime) {
        for (VacuumCleanerCommand command: vacuumCleanerCommands) {
            command.execute(deltaTime);
        }
    }
}
