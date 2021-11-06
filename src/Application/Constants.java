package Application;

import java.awt.*;
import java.io.IOException;

public class Constants {
    public static final Font CUSTOM_MORTAL_ENGINES;

    static {
        CUSTOM_MORTAL_ENGINES = customFont("MortalEngines.ttf");
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
