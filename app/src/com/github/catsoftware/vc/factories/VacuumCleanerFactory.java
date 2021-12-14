package com.github.catsoftware.vc.factories;

import com.github.catsoftware.vc.entities.VacuumCleanerRenderEntity;
import com.github.catsoftware.vc.models.VacuumCleanerModel;

public class VacuumCleanerFactory {
    public static VacuumCleanerRenderEntity factoryEntityBy(VacuumCleanerModel vacuumCleanerModel) {
        return new VacuumCleanerRenderEntity(6 * 16, 6 * 16, 16, 16, vacuumCleanerModel.getDirection());
    }
}
