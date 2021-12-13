package app;

import com.github.catsoftware.vc.graphics.RenderApplication;
import com.github.catsoftware.vc.graphics.Texture;
import com.github.catsoftware.vc.graphics.TextureRegion;
import com.github.catsoftware.vc.inputs.KeyboardInput;
import com.github.catsoftware.vc.inputs.KeyboardInputListener;
import com.github.catsoftware.vc.utils.Global;
import com.github.catsoftware.vc.utils.Log;
import com.github.catsoftware.vc.window.Window;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Application extends RenderApplication {

    private Texture texture = new Texture("assets/sprites/spritesheet.png", 750, 128);
    private TextureRegion floorTextureRegion = new TextureRegion(0, 32, 16, 16, texture);

    private BufferedImage bufferedImage = new BufferedImage(Global.WIDTH, Global.HEIGHT, BufferedImage.TYPE_INT_RGB);

    public Application() {
        super();
    }

    public Application(KeyboardInputListener keyboardInputListener) {
        super(keyboardInputListener);
    }

    @Override
    public void initializeResources() {

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
        graphics.fillRect(0, 0, Global.WIDTH, Global.HEIGHT);

        graphics.setColor(Color.BLUE);
        graphics.drawImage(floorTextureRegion.getTexture(4), 150, 150, null);

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
        application.start();
    }
}
