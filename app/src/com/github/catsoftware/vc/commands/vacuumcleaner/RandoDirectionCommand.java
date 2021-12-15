package com.github.catsoftware.vc.commands.vacuumcleaner;

import com.github.catsoftware.vc.entities.VacuumCleanerRenderEntity;
import com.github.catsoftware.vc.enums.Direction;
import com.github.catsoftware.vc.models.VacuumCleanerModel;

import java.util.Random;

public class RandoDirectionCommand extends VacuumCleanerCommand {

    private float time = 0;
    private Random random = new Random();

    public RandoDirectionCommand(VacuumCleanerModel vacuumCleanerModel, VacuumCleanerRenderEntity vacuumCleanerRenderEntity) {
        super(vacuumCleanerModel, vacuumCleanerRenderEntity);
    }

    @Override
    public void execute(double deltaTime) {
        // Muda a direcao em aproximadamente 1 segundos...
        if (time > 1.5f) {

            int randomDirection = random.nextInt(4);

            while (randomDirection == vacuumCleanerModel.getDirection().ordinal() || randomDirection == vacuumCleanerRenderEntity.getPreviousDirection().ordinal()) {
                randomDirection = random.nextInt(4);
            }

            switch (randomDirection) {
                case 0:
                    vacuumCleanerModel.setDirection(Direction.LEFT);
                    break;
                case 1:
                    vacuumCleanerModel.setDirection(Direction.RIGHT);
                    break;
                case 2:
                    vacuumCleanerModel.setDirection(Direction.UPPER);
                    break;
                case 3:
                    vacuumCleanerModel.setDirection(Direction.DOWN);
                    break;
            }

            time = 0;
        }

        time += deltaTime;
    }
}
