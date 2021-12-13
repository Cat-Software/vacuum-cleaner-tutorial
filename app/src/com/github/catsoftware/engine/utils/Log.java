package com.github.catsoftware.engine.utils;

import javax.swing.*;

public class Log {

    private JFrame jFrame;
    private static Log log;

    public static Log getInstance() {
        if(log == null) {
            log = new Log();
        }

        return log;
    }

    public static void setWindow(JFrame jFrame) {
        getInstance().jFrame = jFrame;
    }

    public static void titleLog(String logText) {
        getInstance().jFrame.setTitle(logText);
    }
}
