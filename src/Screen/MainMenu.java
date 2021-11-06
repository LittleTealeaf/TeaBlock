package Screen;

import Application.Constants;
import UI.Text;

import java.awt.*;

public class MainMenu extends Menu {

    public MainMenu() {
        super();
        drawables.add(new Text("TeaCraft", Constants.FONT_MENU.deriveFont(70f),(w,h) -> new int[] {
                w / 2 - 300, h / 3
        }));
        backgroundColor = new Color(118, 118, 208);
    }
}
