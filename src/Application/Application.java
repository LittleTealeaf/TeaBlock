package Application;

import Keyboard.Keyboard;
import Screen.ScreenManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Application extends JFrame {

    public static Application instance;
    public static Config config;
    private ThreadClock render, ticks;
    private ScreenManager screenManager;
    private static final Dimension GAME_DIMENSIONS;

    static {
        config = new Config();
        GAME_DIMENSIONS = new Dimension(700,700);
    }

    public Application() {
        super("TeaBlock");
        setContentPane(screenManager = new ScreenManager());
        setSize(GAME_DIMENSIONS);
        setMinimumSize(GAME_DIMENSIONS);
        this.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListener(Keyboard.getKeyListener());
        addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                //Clears keys to keep persistent key presses
                Keyboard.clearKeys();
            }
        });
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
        instance = new Application();
    }

    private void paintComponent(Graphics g) {
        super.paintComponents(g);
        screenManager.paintComponent(g);
    }

//    private static void registerFont(String font) {
//        try {
//            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
//            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT,Resources.getResource("/fonts/" + font)));
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
//    }
}
