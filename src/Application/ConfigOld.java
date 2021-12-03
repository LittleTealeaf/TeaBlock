package Application;

import Keyboard.KeyActionOld;
import Keyboard.KeyboardOld;

import java.util.HashMap;
import java.util.Map;

@Deprecated
public class ConfigOld {
    private final int width;
    private final int height;
    private final int framesPerSecond;

    private final Map<KeyActionOld, int[][]> keyBinds;


    public ConfigOld() {
        width = 800;
        height = 700;
        keyBinds = new HashMap<>();
        framesPerSecond = 100;
        addDefaultKeybinds();
    }

    private void addDefaultKeybinds() {
        keyBinds.put(KeyActionOld.MOVE_LEFT, KeyboardOld.newBindSingle(65, 37));
        keyBinds.put(KeyActionOld.MOVE_RIGHT, KeyboardOld.newBindSingle(68, 39));
        keyBinds.put(KeyActionOld.MOVE_UP, KeyboardOld.newBindSingle(87, 38));
        keyBinds.put(KeyActionOld.MOVE_DOWN, KeyboardOld.newBindSingle(83, 40));
        keyBinds.put(KeyActionOld.INVENTORY, KeyboardOld.newBindSingle(69));
        keyBinds.put(KeyActionOld.JUMP, KeyboardOld.newBindSingle(32));

        KeyActionOld[] hotBarActions = new KeyActionOld[]{
                KeyActionOld.HOTBAR_00,
                KeyActionOld.HOTBAR_01,
                KeyActionOld.HOTBAR_02,
                KeyActionOld.HOTBAR_03,
                KeyActionOld.HOTBAR_04,
                KeyActionOld.HOTBAR_05,
                KeyActionOld.HOTBAR_06,
                KeyActionOld.HOTBAR_07,
                KeyActionOld.HOTBAR_08,
                KeyActionOld.HOTBAR_09,
                KeyActionOld.HOTBAR_10,
                KeyActionOld.HOTBAR_11,
                KeyActionOld.HOTBAR_12,
                KeyActionOld.HOTBAR_13,
                KeyActionOld.HOTBAR_14,
                KeyActionOld.HOTBAR_15,
                KeyActionOld.HOTBAR_16,
                KeyActionOld.HOTBAR_17,
                KeyActionOld.HOTBAR_18,
                KeyActionOld.HOTBAR_19
        };
        for(int i = 0; i < hotBarActions.length; i++) {
            if(i/10 == 0) {
                keyBinds.put(hotBarActions[i], KeyboardOld.newBindSingle(i + 48));
            } else if(i / 10 == 1) {
                keyBinds.put(hotBarActions[i], KeyboardOld.newBindMetas(new int[] {KeyboardOld.ALT}, i%10 + 48));
            }
        }
    }

    public int[][] getBinds(KeyActionOld action) {
        return keyBinds.getOrDefault(action,null);
    }



}
