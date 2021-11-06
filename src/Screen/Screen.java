package Screen;

import Engine.Clickable;
import Engine.Drawable;
import Engine.Updatable;
import Application.App;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;


public abstract class Screen implements Clickable, Drawable, Updatable {

    protected List<Drawable> drawables;
    protected Color backgroundColor;

    public Screen() {
        drawables = new ArrayList<>();
    }


    public void mouseClicked(MouseEvent e) {

    }

    private int i = 0;


    public void paintComponent(Graphics g) {
        if(backgroundColor != null) {
            g.setColor(backgroundColor);
            g.fillRect(i, i, App.instance.getWidth(), App.instance.getHeight());
        }
        for(Drawable drawable : drawables) {
            drawable.paintComponent(g);
        }
    }


    public void update() {

    }
}
