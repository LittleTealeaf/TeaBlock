package Application;

import Keyboard.Keyboard;
import Screen.ScreenManager;
import Util.Vector;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class App extends JFrame {

    public static App instance;
    public static ConfigOld configOld;
    private ThreadClock render, ticks;
    private final ScreenManager screenManager;
    private static final Dimension GAME_DIMENSIONS;

    static {
        configOld = new ConfigOld();
        GAME_DIMENSIONS = new Dimension(700,700);
    }

    public App() {
        super("TeaBlock");
        setContentPane(screenManager = new ScreenManager());
        setSize(GAME_DIMENSIONS);
        setMinimumSize(GAME_DIMENSIONS);
        this.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addKeyListener(new Keyboard());
        addFocusListener(new Keyboard());
        addMouseListener(screenManager);
        addMouseMotionListener(screenManager);


        createThreads();
    }

    private void createThreads() {
        render = new ThreadClock(75) {
            @Override
            public void function() {
                repaint();
            }
        };
        ticks = new ThreadClock(0) {
            @Override
            public void function() {
                screenManager.update();
            }
        };
        render.start();
        ticks.start();
    }

    public static void main(String... args) throws IOException {
        instance = new App();
    }
}
