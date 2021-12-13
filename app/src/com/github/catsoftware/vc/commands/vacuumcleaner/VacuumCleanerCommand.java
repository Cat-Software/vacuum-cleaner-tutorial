package com.github.catsoftware.vc.commands.vacuumcleaner;

import com.github.catsoftware.vc.commands.Command;
import com.github.catsoftware.vc.entities.VacuumCleanerRenderEntity;
import com.github.catsoftware.vc.models.VacuumCleanerModel;

public abstract class VacuumCleanerCommand implements Command {

    protected VacuumCleanerModel vacuumCleanerModel;
    protected VacuumCleanerRenderEntity vacuumCleanerRenderEntity;

    public VacuumCleanerCommand(VacuumCleanerModel vacuumCleanerModel, VacuumCleanerRenderEntity vacuumCleanerRenderEntity) {
        this.vacuumCleanerModel = vacuumCleanerModel;
        this.vacuumCleanerRenderEntity = vacuumCleanerRenderEntity;
    }
}
