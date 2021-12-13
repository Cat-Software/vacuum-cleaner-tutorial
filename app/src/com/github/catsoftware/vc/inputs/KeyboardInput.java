package com.github.catsoftware.vc.inputs;

import java.awt.event.KeyEvent;

public class KeyboardInput implements KeyboardInputListener {

    public static final int MAX_KEY_CODE = 256;
    private boolean[] keys = new boolean[MAX_KEY_CODE];
    private int[] keyCount = new int[MAX_KEY_CODE];

    private boolean isValid(int keyCode) {
        return keyCode > 0 && keyCode < MAX_KEY_CODE;
    }

    @Override
    public void applyKeyCount() {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i])
                keyCount[i]++;
            else
                keyCount[i] = 0;
        }
    }

    @Override
    public boolean hasPressed(int keyCode) {
        if (!isValid(keyCode)) return false;

        return keys[keyCode];
    }

    @Override
    public boolean hasPressedOnce(int keyCode) {
        if (!isValid(keyCode)) return false;
        return keyCount[keyCode] == 1;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not implemented
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (!isValid(keyCode)) return;

        keys[keyCode] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (!isValid(keyCode)) return;

        keys[keyCode] = false;
    }
}
