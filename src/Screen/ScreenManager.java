package Screen;

import Interfaces.Drawable;
import Interfaces.Updatable;
import Util.DrawableOld;
import Util.UpdatableOld;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Stack;

public class ScreenManager extends JPanel implements Drawable, Updatable, MouseListener, MouseMotionListener {

    private final Stack<Screen> screenStack;
    //References of static screens

    public ScreenManager() {
        screenStack = new Stack<>();
    }

    public void update() {
        getScreen().update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        getScreen().paintComponent(g);
    }

    public void mouseClicked(MouseEvent e) {
        getScreen().mouseClicked(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        getScreen().mousePressed(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        getScreen().mouseReleased(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        getScreen().mouseEntered(e);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        getScreen().mouseExited(e);
    }

    private void resetStack() {
        screenStack.clear();
//        screenStack.push(new MainMenuOld());
    }

    public Screen getScreen() {
        if(screenStack.size() == 0) {
            resetStack();
        }
        return screenStack.peek();
    }

    public void setScreen(Screen screen) {
        for(int i = 0; i < screenStack.size(); i++) {
            if (screenStack.get(i).getClass() == screen.getClass()) {
                while(screenStack.peek() != screenStack.get(i)) {
                    screenStack.pop();
                }
                return;
            }
        }
        screenStack.push(screen);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        getScreen().mouseDragged(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        getScreen().mouseMoved(e);
    }
}
