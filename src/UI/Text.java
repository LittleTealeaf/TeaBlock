package UI;

import Engine.Drawable;

import java.awt.*;

public class Text implements Drawable {

    private String text;
    private int x,y;
    private ColoredFont font;

    public Text(String text, int x, int y, ColoredFont font) {
        this.text = text;
        this.x = x;
        this.y = y;
        this.font = font;
    }


    @Override
    public void paintComponent(Graphics g) {
        g.setFont(font);
        g.setColor(font.getColor());
        g.drawString(text,x,y);
    }
}
