package app;

import com.github.catsoftware.engine.graphics.RenderApplication;
import com.github.catsoftware.engine.inputs.KeyboardInput;
import com.github.catsoftware.engine.inputs.KeyboardInputListener;
import com.github.catsoftware.engine.tiles.TileMap;
import com.github.catsoftware.engine.utils.Global;
import com.github.catsoftware.engine.utils.Log;
import com.github.catsoftware.engine.window.Window;
import com.github.catsoftware.vc.commands.vacuumcleaner.CheckBoundsCommand;
import com.github.catsoftware.vc.commands.vacuumcleaner.MoveCommand;
import com.github.catsoftware.vc.commands.vacuumcleaner.MoveToOppositeDirectionCommand;
import com.github.catsoftware.vc.commands.vacuumcleaner.VacuumCleanerCommandPool;
import com.github.catsoftware.vc.entities.VacuumCleanerRenderEntity;
import com.github.catsoftware.vc.enums.Direction;
import com.github.catsoftware.vc.factories.VacuumCleanerFactory;
import com.github.catsoftware.vc.maps.Room;
import com.github.catsoftware.vc.models.VacuumCleanerModel;
import com.github.catsoftware.vc.objects.FloorTile;
import com.github.catsoftware.vc.objects.WallFooterTile;
import com.github.catsoftware.vc.objects.WallUpperTile;
import com.github.catsoftware.vc.utils.Temp;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Application extends RenderApplication {

    private VacuumCleanerRenderEntity vacuumCleanerRenderEntity;

    private final VacuumCleanerCommandPool vacuumCleanerCommandPool = new VacuumCleanerCommandPool();

    private final TileMap tileMap = new Room(12, 12, 16);
    private final BufferedImage bufferedImage = new BufferedImage(Global.WIDTH, Global.HEIGHT, BufferedImage.TYPE_INT_RGB);

    public Application() {
        super();
    }

    public Application(KeyboardInputListener keyboardInputListener) {
        super(keyboardInputListener);
    }

    @Override
    public void initializeResources() {
        VacuumCleanerModel vacuumCleanerModel = new VacuumCleanerModel(1, Direction.DOWN, 60.f);
        vacuumCleanerRenderEntity = VacuumCleanerFactory.factoryEntityBy(vacuumCleanerModel);

        vacuumCleanerCommandPool.addCommand(new MoveCommand(vacuumCleanerModel, vacuumCleanerRenderEntity));
        vacuumCleanerCommandPool.addCommand(new CheckBoundsCommand(
                vacuumCleanerModel, vacuumCleanerRenderEntity,
                0, 16 * 2,
                Global.WIDTH / Global.SCALE_FACTOR,
                Global.HEIGHT / Global.SCALE_FACTOR
        ));
        vacuumCleanerCommandPool.addCommand(new MoveToOppositeDirectionCommand(
                vacuumCleanerModel,
                vacuumCleanerRenderEntity
        ));

        tileMap.setData(Temp.data);

        List<String> list = new ArrayList<>();

        list.add(WallFooterTile.class.getName());
        list.add(WallUpperTile.class.getName());
        list.add(FloorTile.class.getName());

        tileMap.load(list);
    }

    @Override
    public void inputs(double deltaTime) {
        keyboardInputListener.applyKeyCount();

        if (keyboardInputListener.hasPressedOnce(KeyEvent.VK_ESCAPE)) {
            System.out.println("ESCAPE HAS BEN PRESSED");
        }
    }

    @Override
    public void update(double deltaTime) {
        vacuumCleanerCommandPool.applyCommands(deltaTime);
        vacuumCleanerRenderEntity.update();
    }

    @Override
    public void render() {
        BufferStrategy bufferStrategy = getBufferStrategy();

        if (bufferStrategy == null) {
            createBufferStrategy(Global.DOUBLE_BUFFER);
            return;
        }

        Graphics graphics = bufferedImage.getGraphics();
        graphics.setColor(Color.BLACK);
        graphics.clearRect(0, 0, Global.WIDTH, Global.HEIGHT);

        tileMap.render(graphics);
        vacuumCleanerRenderEntity.render(graphics);

        graphics = bufferStrategy.getDrawGraphics();
        graphics.drawImage(
                bufferedImage,
                0, 0,
                Global.WIDTH * Global.SCALE_FACTOR,
                Global.HEIGHT * Global.SCALE_FACTOR,
                null
        );

        graphics.dispose();

        do {
            bufferStrategy.show();
        } while (bufferStrategy.contentsLost());
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
