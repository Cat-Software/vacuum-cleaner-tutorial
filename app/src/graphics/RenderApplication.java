package graphics;

import utils.GlobalConfig;
import utils.Graphics;
import utils.Log;

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

    public void waitTime(long sleepTime) {
        try {
            Thread.sleep(sleepTime);
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

        long currentTime = System.currentTimeMillis();
        long lastTime = System.nanoTime();
        boolean shouldRender = false;

        while (isRunning) {
            long time = System.nanoTime();
            long difference = time - lastTime;

            Graphics.deltaTime += difference / Graphics.NS_PER_FSP;
            lastTime = time;

            // 60 atualizacoes por segundo
           while(Graphics.deltaTime >= 1) {
               update();
               Graphics.ups++;
               Graphics.deltaTime--;
               shouldRender = true;
           }

           waitTime(5);

            if(shouldRender) {
                render();
                Graphics.fps++;
                shouldRender = false;
            }

            if(System.currentTimeMillis() - currentTime > 1000) {
                currentTime += 1000;

                Log.titleLog("ups: " + Graphics.ups + "/fps: " + Graphics.fps);

                Graphics.fps = 0;
                Graphics.ups = 0;
            }
        }
    }
}
