package Screen;

import Application.App;
import Application.Constants;
import UI.Text;

import java.awt.*;

public class MainMenu extends Menu {

    public MainMenu() {
        super();
        drawables.add(new Text("TeaCraft", Constants.CUSTOM_MORTAL_ENGINES.deriveFont(70f),Color.RED) {
           public Point getPosition() {
               return new Point(App.instance.getWidth() / 2, App.instance.getHeight() / 3);
           }
        });
        backgroundColor = new Color(118, 118, 208);
    }
}
