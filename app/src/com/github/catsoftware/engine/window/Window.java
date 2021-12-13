package com.github.catsoftware.engine.window;

import com.github.catsoftware.engine.graphics.RenderApplication;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Window extends JFrame {

    public Window(RenderApplication renderApplication, String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(renderApplication);

        pack();

        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                renderApplication.stop();
                renderApplication.dispose();
            }
        });
    }
}
