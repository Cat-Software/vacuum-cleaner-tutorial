package app;

import com.github.catsoftware.engine.graphics.RenderApplication;
import com.github.catsoftware.engine.tiles.tiled.Map;
import com.github.catsoftware.engine.tiles.tiled.TiledLoaderMap;
import com.github.catsoftware.engine.window.Window;
import com.github.catsoftware.engine.inputs.KeyboardInput;
import com.github.catsoftware.engine.inputs.KeyboardInputListener;
import com.github.catsoftware.engine.tiles.TileMap;
import com.github.catsoftware.engine.utils.Global;
import com.github.catsoftware.engine.utils.Log;
import com.github.catsoftware.vc.commands.vacuumcleaner.*;
import com.github.catsoftware.vc.entities.TrashRenderEntity;
import com.github.catsoftware.vc.entities.VacuumCleanerRenderEntity;
import com.github.catsoftware.vc.enums.Direction;
import com.github.catsoftware.vc.factories.VacuumCleanerFactory;
import com.github.catsoftware.vc.maps.Room;
import com.github.catsoftware.vc.models.VacuumCleanerModel;
import com.github.catsoftware.vc.objects.FloorTile;
import com.github.catsoftware.vc.objects.MiniTable;
import com.github.catsoftware.vc.objects.Television;
import com.github.catsoftware.vc.objects.carpet.*;
import com.github.catsoftware.vc.objects.chairs.back.ChairDownBack;
import com.github.catsoftware.vc.objects.chairs.back.ChairUpperBack;
import com.github.catsoftware.vc.objects.chairs.front.ChairDownFront;
import com.github.catsoftware.vc.objects.chairs.front.ChairUpperFront;
import com.github.catsoftware.vc.objects.chairs.left.ChairDownLeft;
import com.github.catsoftware.vc.objects.chairs.left.ChairUpperLeft;
import com.github.catsoftware.vc.objects.chairs.right.ChairDownRight;
import com.github.catsoftware.vc.objects.chairs.right.ChairUpperRight;
import com.github.catsoftware.vc.objects.lamp.LampDown;
import com.github.catsoftware.vc.objects.lamp.LampUpper;
import com.github.catsoftware.vc.objects.plant.PlantDown;
import com.github.catsoftware.vc.objects.plant.PlantUpper;
import com.github.catsoftware.vc.objects.shelf.ShelfDown;
import com.github.catsoftware.vc.objects.shelf.ShelfUpper;
import com.github.catsoftware.vc.objects.table.TableLeftDownCorner;
import com.github.catsoftware.vc.objects.table.TableLeftUpperCorner;
import com.github.catsoftware.vc.objects.table.TableRightDownCorner;
import com.github.catsoftware.vc.objects.table.TableRightUpperCorner;
import com.github.catsoftware.vc.objects.wall.WallFooterTile;
import com.github.catsoftware.vc.objects.wall.WallUpperTile;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Application extends RenderApplication {

    private MoveLeftCommand moveLeftCommand;
    private MoveRightCommand moveRightCommand;
    private MoveUpperCommand moveUpperCommand;
    private MoveDownCommand moveDownCommand;

    private TrashRenderEntity trashRenderEntity;
    private VacuumCleanerRenderEntity vacuumCleanerRenderEntity;

    private final VacuumCleanerCommandPool vacuumCleanerCommandPool = new VacuumCleanerCommandPool();

    private TileMap tileMap;
    private final BufferedImage bufferedImage = new BufferedImage(Global.WIDTH, Global.HEIGHT, BufferedImage.TYPE_INT_RGB);

    public Application() {
        super();
    }

    public Application(KeyboardInputListener keyboardInputListener) {
        super(keyboardInputListener);
    }

    @Override
    public synchronized void initializeResources() {
        trashRenderEntity = new TrashRenderEntity(3 * 16, 3 * 16, 8, 8);

        VacuumCleanerModel vacuumCleanerModel = new VacuumCleanerModel(1, Direction.RIGHT, 200.00f);
        vacuumCleanerRenderEntity = VacuumCleanerFactory.factoryEntityBy(vacuumCleanerModel);

        moveLeftCommand = new MoveLeftCommand(vacuumCleanerModel, vacuumCleanerRenderEntity);
        moveRightCommand = new MoveRightCommand(vacuumCleanerModel, vacuumCleanerRenderEntity);
        moveUpperCommand = new MoveUpperCommand(vacuumCleanerModel, vacuumCleanerRenderEntity);
        moveDownCommand = new MoveDownCommand(vacuumCleanerModel, vacuumCleanerRenderEntity);

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
        vacuumCleanerCommandPool.addCommand(new RandoDirectionCommand(vacuumCleanerModel, vacuumCleanerRenderEntity));

        // Load map stuffs...
        try {
            Map map = new TiledLoaderMap("assets/tiles/room_map.xml").createMap();
            tileMap = new Room(map, 16);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }

        List<String> objectsList = new ArrayList<>();

        objectsList.add(WallFooterTile.class.getName());
        objectsList.add(WallUpperTile.class.getName());
        objectsList.add(FloorTile.class.getName());

        // Tapete
        objectsList.add(CarpetLeftUpperCorner.class.getName());
        objectsList.add(CarpetCenterUpperCorner.class.getName());
        objectsList.add(CarpetRightUpperCorner.class.getName());
        objectsList.add(CarpetLeftDownCorner.class.getName());
        objectsList.add(CarpetCenterDownCorner.class.getName());
        objectsList.add(CarpetRightDownCorner.class.getName());

        // Mesa
        objectsList.add(TableLeftUpperCorner.class.getName());
        objectsList.add(TableRightUpperCorner.class.getName());
        objectsList.add(TableLeftDownCorner.class.getName());
        objectsList.add(TableRightDownCorner.class.getName());

        // Estante
        objectsList.add(ShelfUpper.class.getName());
        objectsList.add(ShelfDown.class.getName());

        // Mini mesa
        objectsList.add(MiniTable.class.getName());

        // Televisao
        objectsList.add(Television.class.getName());

        // Cadeiras
        // cadeira esquerda
        objectsList.add(ChairUpperLeft.class.getName());
        objectsList.add(ChairDownLeft.class.getName());

        // cadeira direita
        objectsList.add(ChairUpperRight.class.getName());
        objectsList.add(ChairDownRight.class.getName());

        // cadeira de tras
        objectsList.add(ChairUpperBack.class.getName());
        objectsList.add(ChairDownBack.class.getName());

        // cadeira da frente
        objectsList.add(ChairUpperFront.class.getName());
        objectsList.add(ChairDownFront.class.getName());

        // Iluminaria
        objectsList.add(LampUpper.class.getName());
        objectsList.add(LampDown.class.getName());

        // Planta
        objectsList.add(PlantUpper.class.getName());
        objectsList.add(PlantDown.class.getName());

        tileMap.load(objectsList);

        // Finish load map sutffs
        addNotify();
    }

    @Override
    public void inputs(double deltaTime) {
        keyboardInputListener.applyKeyCount();

        if (keyboardInputListener.hasPressedOnce(KeyEvent.VK_ESCAPE)) {
            System.out.println("ESCAPE HAS BEN PRESSED");
        }

        if(keyboardInputListener.hasPressed(KeyEvent.VK_NUMPAD4)) {
            moveLeftCommand.execute(deltaTime);
        }

        if(keyboardInputListener.hasPressed(KeyEvent.VK_NUMPAD6)) {
            moveRightCommand.execute(deltaTime);
        }

        if(keyboardInputListener.hasPressed(KeyEvent.VK_NUMPAD8)) {
            moveUpperCommand.execute(deltaTime);
        }

        if(keyboardInputListener.hasPressed(KeyEvent.VK_NUMPAD2)) {
            moveDownCommand.execute(deltaTime);
        }
    }

    @Override
    public void update(double deltaTime) {
//        vacuumCleanerCommandPool.applyCommands(deltaTime);
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

        tileMap.renderOneEntityInLayer(graphics, vacuumCleanerRenderEntity, 1);
        trashRenderEntity.render(graphics);

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
