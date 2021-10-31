package Game;

import Engine.GamePanel;
import Keyboard.Keyboard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import Keyboard.KeyAction;

public class Application extends JFrame {

    public static Config config;
    private ThreadClock render, ticks;
    private GamePanel gamePanel;

    static {
        config = new Config();
    }

    public Application() {
        super("TeaBlock");
        setContentPane(gamePanel = new GamePanel());
        setSize(700,700);
        this.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListener(Keyboard.getKeyListener());
        addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
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
                gamePanel.update();
            }
        };
        render.start();
        ticks.start();
    }

    public static void main(String... args) {
        new Application();

    }

    private void paintComponent(Graphics g) {
        super.paintComponents(g);
    }


}
