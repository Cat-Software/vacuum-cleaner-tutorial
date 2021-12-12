package app;

import graphics.RenderApplication;
import utils.GlobalConfig;
import utils.Log;
import window.Window;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Application extends RenderApplication {

    private BufferedImage bufferedImage = new BufferedImage(GlobalConfig.WIDTH, GlobalConfig.HEIGHT, BufferedImage.TYPE_INT_RGB);

    @Override
    public void initializeResources() {

    }

    @Override
    public void update() {

    }

    @Override
    public void render() {
        BufferStrategy bufferStrategy = getBufferStrategy();

        if(bufferStrategy == null) {
            createBufferStrategy(GlobalConfig.DOUBLE_BUFFER);
            return;
        }

        Graphics graphics = bufferedImage.getGraphics();
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, GlobalConfig.WIDTH, GlobalConfig.HEIGHT);

        graphics.setColor(Color.BLUE);
        graphics.fillRect(150, 150, 200, 200);

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

        Application application = new Application();
        Window window = new Window(application, "Vacuum Cleaner");

        Log.setWindow(window);

        application.start();
    }
}
