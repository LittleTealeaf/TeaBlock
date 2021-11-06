package Screen;

import Application.App;
import Application.Constants;
import UI.Text;
import Menu.Menu;

import java.awt.*;

public class MainMenu extends Menu {

    public MainMenu() {
        super();
        Color option = new Color(248, 215, 1);

        Color selected = new Color(236, 39, 6);

        drawables.add(new Text("TeaCraft", Constants.CUSTOM_MORTAL_ENGINES.deriveFont(70f),option) {
           public Point getPosition() {
               return new Point(App.instance.getWidth() / 2, App.instance.getHeight()/ 5);
           }
        });
        backgroundColor = new Color(118, 118, 208);
    }
}
