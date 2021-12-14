package com.github.catsoftware.engine.graphics;

import com.github.catsoftware.engine.inputs.KeyboardInputListener;
import com.github.catsoftware.engine.utils.Global;
import com.github.catsoftware.engine.utils.Graphics;
import com.github.catsoftware.engine.utils.Log;

import java.awt.*;

public abstract class RenderApplication extends Canvas implements Runnable {

    private boolean isRunning;
    private Thread renderApplicationThread;
    protected KeyboardInputListener keyboardInputListener;

    public RenderApplication() {
        setSize();
    }

    public RenderApplication(KeyboardInputListener keyboardInputListener) {
        this.keyboardInputListener = keyboardInputListener;
        setSize();
    }

    private void setSize() {
        setMinimumSize(new Dimension(Global.WIDTH, Global.HEIGHT));
        setMaximumSize(new Dimension(Global.WIDTH, Global.HEIGHT));
        setPreferredSize(new Dimension(Global.WIDTH, Global.HEIGHT));
    }

    public void activeKeyboardListener() {
        addKeyListener(keyboardInputListener);
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
        System.exit(0);
    }

    public void waitTime(long sleepTime) {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public abstract void initializeResources();

    public abstract void inputs(double deltaTime);

    public abstract void update(double deltaTime);

    public abstract void render();

    public abstract void dispose();

    @Override
    public void run() {

        long currentTime = System.currentTimeMillis();
        long lastTime = System.nanoTime();
        boolean shouldRender = false;

        double perfectDelta = 0; // 16ms

        while (isRunning) {
            long time = System.nanoTime();
            long difference = time - lastTime;
            lastTime = time;

            perfectDelta += difference / Graphics.NS_PER_FSP;

            Graphics.deltaTime = difference;

            while (perfectDelta > 1) {
                inputs(Graphics.deltaTime / 1e+9);
                update(Graphics.deltaTime / 1e+9);
                Graphics.ups++;
                perfectDelta--;
                shouldRender = true;
            }

            waitTime(16);

            if (shouldRender) {
                render();
                Graphics.fps++;
                shouldRender = false;
            }

            if (System.currentTimeMillis() - currentTime > 1000) {
                currentTime += 1000;

                Log.titleLog("DEBUG | ups: " + Graphics.ups + "/fps: " + Graphics.fps);

                Graphics.fps = 0;
                Graphics.ups = 0;
            }
        }
    }
}
