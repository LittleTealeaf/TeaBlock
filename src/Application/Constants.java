package Application;

import java.awt.*;
import java.io.IOException;

public class Constants {
    public static final Font FONT_MA;

    static {
        FONT_MA = customFont("MortalEngines.ttf");
    }

    private static Font customFont(String string) {
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, Resources.getResource("/fonts/" + string));
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(font);
            return font;
        } catch(IOException|FontFormatException exception) {
            exception.printStackTrace();

            //Set default font to Times New Roman
            return new Font("Times New Roman",Font.PLAIN,10);
        }
    }
}
