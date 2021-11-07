package Screen;

import Util.Drawable;
import Util.Updatable;
import Application.App;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;


public abstract class Screen implements MouseMotionListener, MouseListener, Drawable, Updatable {

    protected List<Drawable> drawables;
    protected Color backgroundColor;

    public Screen() {
        drawables = new ArrayList<>();
    }

    @Override
    public void paintComponent(Graphics g) {
        if(backgroundColor != null) {
            g.setColor(backgroundColor);
            g.fillRect(0, 0, App.instance.getWidth(), App.instance.getHeight());
        }
        for(Drawable drawable : drawables) {
            drawable.paintComponent(g);
        }
    }


    @Override
    public void update() {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
