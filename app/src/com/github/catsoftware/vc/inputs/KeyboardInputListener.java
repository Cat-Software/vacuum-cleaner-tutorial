package com.github.catsoftware.vc.inputs;

import java.awt.event.KeyListener;

public interface KeyboardInputListener extends KeyListener {

    void applyKeyCount();

    boolean hasPressed(int keyCode);

    boolean hasPressedOnce(int keyCode);

}
