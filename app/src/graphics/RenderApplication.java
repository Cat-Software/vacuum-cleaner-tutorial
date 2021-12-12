package graphics;

import utils.GlobalConfig;

import java.awt.*;

public abstract class RenderApplication extends Canvas implements Runnable {

    private boolean isRunning;
    private Thread renderApplicationThread;

    public RenderApplication() {
        setMinimumSize(new Dimension(GlobalConfig.WIDTH, GlobalConfig.HEIGHT));
        setMaximumSize(new Dimension(GlobalConfig.WIDTH, GlobalConfig.HEIGHT));
        setPreferredSize(new Dimension(GlobalConfig.WIDTH, GlobalConfig.HEIGHT));
    }

    public synchronized void start() {
        isRunning = true;
        renderApplicationThread = new Thread(this, "RenderApplicationThread");
        renderApplicationThread.start();
    }

    public synchronized void stop() {
        isRunning = false;
        try {
            renderApplicationThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public abstract void initializeResources();

    public abstract void update();

    public abstract void render();

    public abstract void dispose();

    @Override
    public void run() {
        while (isRunning) {
            update();
            render();
        }
    }
}
