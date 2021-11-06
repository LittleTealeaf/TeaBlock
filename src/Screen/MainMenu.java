package Screen;

import Application.Constants;
import UI.Text;

import java.awt.*;

public class MainMenu extends Menu {

    public MainMenu() {
        super();
        drawables.add(new Text("Hello", 0, 100, Constants.FONT_MENU));
        backgroundColor = new Color(118, 118, 208);
    }
}
