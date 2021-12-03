package Keyboard;

import java.util.*;

/**
 * List of registered key actions and their respective default key-binds
 */
public enum KeyAction {
    MOVE_LEFT(new KeyBind(65, 37)),
    MOVE_RIGHT(new KeyBind(68, 39)),
    MOVE_UP(new KeyBind(87, 38)),
    MOVE_DOWN(new KeyBind(83, 40));

    private List<KeyBind> keyBinds;

    KeyAction() {
        keyBinds = new ArrayList<>();
    }

    KeyAction(KeyBind... keyBinds) {
        this.keyBinds = Arrays.asList(keyBinds);
    }

    public boolean isDown() {
        for(KeyBind keyBind : keyBinds) {
            if(keyBind.isDown()) {
                return true;
            }
        }
        return false;
    }

    public static class SerializableKeybinding {

        private final Map<KeyAction,List<KeyBind>> map;

        public SerializableKeybinding() {
            map = new HashMap<>();
            for(KeyAction keyAction : values()) {
                if(keyAction.keyBinds != null) {
                    map.put(keyAction,keyAction.keyBinds);
                }
            }
        }

        public void load() {
            for(KeyAction keyAction : values()) {
                keyAction.keyBinds = map.getOrDefault(keyAction,new ArrayList<>());
            }
        }

    }
}
