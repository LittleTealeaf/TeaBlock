package Screen;

import Application.App;
import Application.Constants;
import UI.TextOld;
import Menu.MenuOld;

import java.awt.*;

import Menu.MenuOptionOld;

public class MainMenuOld extends MenuOld {

    public MainMenuOld() {
        super();
        Color option = new Color(248, 215, 1);

        Color selected = new Color(236, 39, 6);

        drawableOlds.add(new TextOld("TeaCraft", Constants.FONT_ME.deriveFont(70f), option) {
           public Point getPosition() {
               return new Point(App.instance.getWidth() / 2, App.instance.getHeight()/ 5);
           }
        });
        backgroundColor = new Color(118, 118, 208);

        MenuOptionOld[][] menuOptionOlds = new MenuOptionOld[][] {
                {
                        new MenuOptionOld("Play", Constants.FONT_ME.deriveFont(30f), option, selected, () -> System.out.println("Play Clicked")) {
                            public Point getPosition() {
                                return new Point(
                                        App.instance.getWidth() / 2 - 200, App.instance.getHeight() / 2 - 100
                                );
                            }
                        }
                }
        };

        setMenuItems(menuOptionOlds);
    }
}
