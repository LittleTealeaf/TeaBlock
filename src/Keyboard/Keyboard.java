package Keyboard;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

public class Keyboard implements FocusListener, KeyListener {

    private static final Set<Integer> keysDown;

    static {
        keysDown = new HashSet<>();
    }

    @Override
    public void focusGained(FocusEvent focusEvent) {

    }

    @Override
    public void focusLost(FocusEvent focusEvent) {
        keysDown.clear();
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        keysDown.add(keyEvent.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        keysDown.remove(keyEvent.getKeyCode());
    }

    public static boolean isKeyDown(Integer keyCode) {
        return keysDown.contains(keyCode);
    }
}
