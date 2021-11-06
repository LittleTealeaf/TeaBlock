package Application;

import Keyboard.Keyboard;
import Screen.ScreenManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App extends JFrame {

    public static App instance;
    public static Config config;
    private ThreadClock render, ticks;
    private ScreenManager screenManager;
    private static final Dimension GAME_DIMENSIONS;

    static {
        config = new Config();
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
        addMouseMotionListener(screenManager);
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

    public static void main(String... args) {
        instance = new App();
    }
}
