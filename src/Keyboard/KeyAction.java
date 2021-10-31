package Keyboard;

import Game.Application;
import Util.StringFunctions;

public enum KeyAction {
    MOVE_UP, MOVE_DOWN, MOVE_LEFT, MOVE_RIGHT, JUMP, INVENTORY, HOTBAR_01, HOTBAR_02, HOTBAR_03, HOTBAR_04, HOTBAR_05, HOTBAR_06, HOTBAR_07,
    HOTBAR_08, HOTBAR_09, HOTBAR_00,HOTBAR_11,HOTBAR_12,HOTBAR_13,HOTBAR_14,HOTBAR_15,HOTBAR_16,HOTBAR_17,HOTBAR_18,HOTBAR_19,HOTBAR_10;

    private String string;

    KeyAction() {
        string = StringFunctions.enumString(super.toString());
    }

    public String toString() {
        return string;
    }

    public boolean isDown() {
        return Keyboard.isKeyBindsDown(Application.config.getBinds(this));
    }
}
