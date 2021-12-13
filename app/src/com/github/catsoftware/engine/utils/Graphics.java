package com.github.catsoftware.engine.utils;

public class Graphics {

    public static final double IDEAL_FPS = 60.0f;
    public static final double NS_PER_FSP = 1_000_000_000.0 / IDEAL_FPS; // 16ms

    public static int ups = 0;
    public static int fps = 0;

    public static double deltaTime = 0;

}
