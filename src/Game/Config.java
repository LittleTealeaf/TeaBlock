package Game;

import Keyboard.KeyAction;
import Keyboard.Keyboard;

import java.util.HashMap;
import java.util.Map;

public class Config {
    private int width, height, framesPerSecond;

    private Map<KeyAction, int[][]> keyBinds;


    public Config() {
        width = 800;
        height = 700;
        keyBinds = new HashMap<>();
        framesPerSecond = 100;
        addDefaultKeybinds();
    }

    private void addDefaultKeybinds() {
        keyBinds.put(KeyAction.MOVE_LEFT,Keyboard.newBindSingle(65,37));
        keyBinds.put(KeyAction.MOVE_RIGHT,Keyboard.newBindSingle(68,39));
        keyBinds.put(KeyAction.MOVE_UP, Keyboard.newBindSingle(87,38));
        keyBinds.put(KeyAction.MOVE_DOWN, Keyboard.newBindSingle(83,40));
        keyBinds.put(KeyAction.INVENTORY, Keyboard.newBindSingle(69));
        keyBinds.put(KeyAction.JUMP,Keyboard.newBindSingle(32));

        KeyAction[] hotBarActions = new KeyAction[]{
                KeyAction.HOTBAR_00,
                KeyAction.HOTBAR_01,
                KeyAction.HOTBAR_02,
                KeyAction.HOTBAR_03,
                KeyAction.HOTBAR_04,
                KeyAction.HOTBAR_05,
                KeyAction.HOTBAR_06,
                KeyAction.HOTBAR_07,
                KeyAction.HOTBAR_08,
                KeyAction.HOTBAR_09,
                KeyAction.HOTBAR_10,
                KeyAction.HOTBAR_11,
                KeyAction.HOTBAR_12,
                KeyAction.HOTBAR_13,
                KeyAction.HOTBAR_14,
                KeyAction.HOTBAR_15,
                KeyAction.HOTBAR_16,
                KeyAction.HOTBAR_17,
                KeyAction.HOTBAR_18,
                KeyAction.HOTBAR_19
        };
        for(int i = 0; i < hotBarActions.length; i++) {
            if(i/10 == 0) {
                keyBinds.put(hotBarActions[i],Keyboard.newBindSingle(i + 48));
            } else if(i / 10 == 1) {
                keyBinds.put(hotBarActions[i],Keyboard.newBindMetas(new int[] {Keyboard.ALT}, i%10 + 48));
            }
        }
    }

    public int[][] getBinds(KeyAction action) {
        return keyBinds.getOrDefault(action,null);
    }



}
