package Screen;

import Engine.Clickable;
import Engine.Drawable;
import Engine.Updatable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.Stack;

public class ScreenManager extends JPanel implements Drawable, Updatable, Clickable {

    private Stack<Screen> screenStack;
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

    private void resetStack() {
        screenStack.clear();
        screenStack.push(new MainMenu());
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
}
