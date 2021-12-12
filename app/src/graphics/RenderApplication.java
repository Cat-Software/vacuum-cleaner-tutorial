package graphics;

import utils.GlobalConfig;
import utils.VCGraphics;
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

            VCGraphics.deltaTime += difference / VCGraphics.NS_PER_FSP;
            lastTime = time;

            // 60 atualizacoes por segundo
           while(VCGraphics.deltaTime >= 1) {
               update();
               VCGraphics.ups++;
               VCGraphics.deltaTime--;
               shouldRender = true;
           }

           waitTime(5);

            if(shouldRender) {
                render();
                VCGraphics.fps++;
                shouldRender = false;
            }

            if(System.currentTimeMillis() - currentTime > 1000) {
                currentTime += 1000;

                Log.titleLog("ups: " + VCGraphics.ups + "/fps: " + VCGraphics.fps);

                VCGraphics.fps = 0;
                VCGraphics.ups = 0;
            }
        }
    }
}
