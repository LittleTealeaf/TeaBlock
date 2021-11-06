package Application;

import UI.ColoredFont;

import java.awt.*;
import java.io.IOException;

public class Constants {
    public final static ColoredFont FONT_MENU,FONT_MENU_SELECTED;
    private static final Font CUSTOM_MORTAL_ENGINES;

    static {
        CUSTOM_MORTAL_ENGINES = customFont("MortalEngines.ttf");

        final int menuSize = 50;
        FONT_MENU = new ColoredFont(CUSTOM_MORTAL_ENGINES, menuSize,Color.WHITE);
        FONT_MENU_SELECTED = new ColoredFont(CUSTOM_MORTAL_ENGINES,Font.BOLD,menuSize,Color.PINK);
    }

    private static Font customFont(String string) {
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, Resources.getResource("/fonts/" + string));
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(font);
            return font;
        } catch(IOException|FontFormatException exception) {
            exception.printStackTrace();
            //default
            return new Font("Times New Roman",Font.PLAIN,10);
        }
    }
}
