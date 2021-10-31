package Keyboard;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Keyboard {

    private static final KeyListener keyListener;

    private static final Set<Integer> keysDown;

    public static transient int SHIFT,ALT,CTRL;

    static {

        SHIFT = 16;
        CTRL = 17;
        ALT = 18;

        keyListener = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                keysDown.add(e.getKeyCode());
                System.out.println(keysDown);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                keysDown.remove(e.getKeyCode());
            }
        };
        keysDown = new HashSet<>();
    }

    public static KeyListener getKeyListener() {
        return keyListener;
    }


    public static boolean isKeyBindsDown(int[][] keyBinds) {
        for(int[] bind : keyBinds) {
            if(isKeyBindDown(bind)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isKeyBindDown(int[] keyBind) {
        for(int i : keyBind) {
            if(!keysDown.contains(i)) {
                return false;
            }
        }
        return true;
    }

    public static void clearKeys() {
        keysDown.clear();
    }

    public static Integer[] getKeysDown() {
        return keysDown.toArray(Integer[]::new);
    }

    public static int[][] newBindSingle(int... keys) {
        int[][] binds = new int[keys.length][1];
        for(int i = 0; i < binds.length; i++) {
            binds[i][0] = keys[i];
        }
        return binds;
    }

    public static int[][] newBindMetas(int[] metas, int... keys) {
        int[][] binds = new int[keys.length][];
        for(int i = 0; i < keys.length; i++) {
            binds[i] = new int[metas.length + 1];
            binds[i][binds[i].length - 1] = keys[i];
            for(int j = 0; j < binds[i].length - 1; j++) {
                binds[i][j] = metas[j];
            }
        }
        return binds;
    }
}
