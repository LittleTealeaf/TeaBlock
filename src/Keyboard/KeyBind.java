package Keyboard;

public class KeyBind {

    private final Integer[] keys;

    public KeyBind(KeyDictionary... keys) {
        this(KeyDictionary.toKeyCodes(keys));
    }

    public KeyBind(Integer... keys) {
        this.keys = keys;
    }

    public boolean isDown() {
        for(Integer i : keys) {
            if(!Keyboard.isKeyDown(i)) {
                return false;
            }
        }
        return true;
    }
}