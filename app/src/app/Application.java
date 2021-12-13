package app;

import com.github.catsoftware.engine.graphics.RenderApplication;
import com.github.catsoftware.engine.inputs.KeyboardInput;
import com.github.catsoftware.engine.inputs.KeyboardInputListener;
import com.github.catsoftware.engine.utils.Global;
import com.github.catsoftware.engine.utils.Log;
import com.github.catsoftware.engine.window.Window;
import com.github.catsoftware.vc.commands.vacuumcleaner.CheckBoundsCollisionVacuumCleanerCommand;
import com.github.catsoftware.vc.commands.vacuumcleaner.MoveToOppositeDirectionVacuumCleanerCommand;
import com.github.catsoftware.vc.commands.vacuumcleaner.MoveVacuumCleanerCommand;
import com.github.catsoftware.vc.entities.VacuumCleanerRenderEntity;
import com.github.catsoftware.vc.enums.Direction;
import com.github.catsoftware.vc.factories.VacuumCleanerFactory;
import com.github.catsoftware.vc.models.VacuumCleanerModel;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Application extends RenderApplication {

    private VacuumCleanerModel vacuumCleanerModel;
    private VacuumCleanerRenderEntity vacuumCleanerRenderEntity;

    private MoveVacuumCleanerCommand moveVacuumCleanerCommand;
    private MoveToOppositeDirectionVacuumCleanerCommand moveToOppositeDirectionVacuumCleanerCommand;

    private CheckBoundsCollisionVacuumCleanerCommand checkBoundsCollisionVacuumCleanerCommand;

    private BufferedImage bufferedImage = new BufferedImage(Global.WIDTH, Global.HEIGHT, BufferedImage.TYPE_INT_RGB);

    public Application() {
        super();
    }

    public Application(KeyboardInputListener keyboardInputListener) {
        super(keyboardInputListener);
    }

    @Override
    public void initializeResources() {
        vacuumCleanerModel = new VacuumCleanerModel(1, Direction.LEFT, 400.0f);
        vacuumCleanerRenderEntity = VacuumCleanerFactory.factoryEntityBy(vacuumCleanerModel);

        moveVacuumCleanerCommand = new MoveVacuumCleanerCommand(vacuumCleanerModel, vacuumCleanerRenderEntity);
        moveToOppositeDirectionVacuumCleanerCommand = new MoveToOppositeDirectionVacuumCleanerCommand(
                vacuumCleanerModel,
                vacuumCleanerRenderEntity
        );

        checkBoundsCollisionVacuumCleanerCommand = new CheckBoundsCollisionVacuumCleanerCommand(
                vacuumCleanerModel, vacuumCleanerRenderEntity,
                0,0,
                Global.WIDTH,
                Global.HEIGHT
        );
    }

    @Override
    public void inputs(double deltaTime) {
        keyboardInputListener.applyKeyCount();

        if(keyboardInputListener.hasPressedOnce(KeyEvent.VK_ESCAPE)) {
            System.out.println("ESCAPE HAS BEN PRESSED");
        }

//        if(keyboardInputListener.hasPressed(KeyEvent.VK_ESCAPE)) {
//            System.out.println("ESCAPE HAS BEN PRESSED");
//        }
    }

    @Override
    public void update(double deltaTime) {

        moveVacuumCleanerCommand.execute(deltaTime);
        checkBoundsCollisionVacuumCleanerCommand.execute(deltaTime);

        if (vacuumCleanerModel.hasCollision()) {
            moveToOppositeDirectionVacuumCleanerCommand.execute(deltaTime);
        }

        vacuumCleanerRenderEntity.update();
    }

    @Override
    public void render() {
        BufferStrategy bufferStrategy = getBufferStrategy();

        if(bufferStrategy == null) {
            createBufferStrategy(Global.DOUBLE_BUFFER);
            return;
        }

        Graphics graphics = bufferedImage.getGraphics();
        graphics.setColor(Color.BLACK);
        graphics.clearRect(0, 0, Global.WIDTH, Global.HEIGHT);

        graphics.setColor(Color.BLUE);
        vacuumCleanerRenderEntity.render(graphics);

        graphics = bufferStrategy.getDrawGraphics();
        graphics.drawImage(bufferedImage, 0, 0, null);

        graphics.dispose();

        do {
            bufferStrategy.show();
        } while(bufferStrategy.contentsLost());
    }

    @Override
    public void dispose() {

    }

    public static void main(String[] args) {
        KeyboardInput keyboardInput = new KeyboardInput();
        Application application = new Application(keyboardInput);
        Window window = new Window(application, "Vacuum Cleaner");

        Log.setWindow(window);

        application.activeKeyboardListener();
        application.initializeResources();
        application.start();
    }
}
