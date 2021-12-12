package app;

import graphics.RenderApplication;
import utils.Log;
import window.Window;

import java.awt.*;

public class Application extends RenderApplication {

    @Override
    public void initializeResources() {

    }

    @Override
    public void update() {

    }

    @Override
    public void render() {
        setBackground(Color.BLACK);
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
