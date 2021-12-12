package app;

import graphics.RenderApplication;
import window.Window;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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

        application.start();

    }
}
