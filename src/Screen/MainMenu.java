package Screen;

import Application.Constants;
import UI.Text;

import java.awt.*;

public class MainMenu extends Menu {

    public MainMenu() {
        super();
        drawables.add(new Text("TeaCraft", Constants.FONT_MENU,(w,h) -> new int[] {
                w / 2 - 300, h / 2 - 100
        }));
        backgroundColor = new Color(118, 118, 208);
    }
}
