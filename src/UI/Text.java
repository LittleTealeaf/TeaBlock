package UI;

import Application.Application;
import Engine.Drawable;
import Engine.Updatable;

import java.awt.*;
import java.util.Locale;

public class Text implements Drawable {

    private String text;
    private int[] loc;
    private ColoredFont font;
    private Scaler scaler;

    public Text(String text, ColoredFont font, int x, int y) {
        this.text = text;
        this.loc = new int[] {x,y};
        this.font = font;
    }

    public Text(String text, ColoredFont font, Scaler scaler) {
        this.text = text;
        this.font = font;
        this.scaler = scaler;
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setFont(font);
        g.setColor(font.getColor());

        if(scaler != null) {
            loc = scaler.scale(Application.instance.getWidth(),Application.instance.getHeight());
        }

        g.drawString(text,loc[0],loc[1]);
    }
}
