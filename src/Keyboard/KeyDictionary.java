package Keyboard;

public enum KeyDictionary {
    CTRL(0),ALT(1),SHIFT(2);

    private int keyCode;

    KeyDictionary(int keyCode) {
        this.keyCode = keyCode;
    }

    public int getKeyCode() {
        return keyCode;
    }

    public static Integer[] toKeyCodes(KeyDictionary... dictionaries) {
        Integer[] val = new Integer[dictionaries.length];
        for(int i = 0; i < val.length; i++) {
            val[i] = dictionaries[i].getKeyCode();
        }
        return val;
    }
}
