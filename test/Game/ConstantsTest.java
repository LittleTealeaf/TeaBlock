package Game;

import Application.Constants;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.util.Arrays;

public class ConstantsTest {
    private static String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();



    private boolean checkFont(Font font) {
        for(String f : fonts) {
            if(font.getFamily().contentEquals(f)) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void testFonts() {
        Font[] list = new Font[] {
                Constants.FONT_MENU_SELECTED,
                Constants.FONT_MENU
        };
        for(Font font : list) {
            Assert.assertTrue(checkFont(font));
        }
    }

    @Test
    public void listFonts() {
        System.out.println(Arrays.toString(fonts));
        Assert.assertNotNull(fonts);
    }
}