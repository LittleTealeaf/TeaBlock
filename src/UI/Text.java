package UI;

import Engine.Drawable;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Text implements Drawable {

    protected String text;
    protected Point position;
    protected Font font;
    protected Color color;

    public Text(String text, Font font, Color color) {
        this(text,font,color,new Point(0,0));
    }

    public Text(String text, Font font, Color color, Point position) {
        this.text = text;
        this.position = position;
        this.color = color;
        this.font = font;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Point getPosition() {
        return position;
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setFont(getFont());
        g.setColor(getColor());

        Point pos = getPosition();
        Rectangle2D rect = g.getFontMetrics().getStringBounds(text,g);

        g.drawString(text,(int) (pos.x - rect.getWidth() / 2),(int) (pos.y - rect.getHeight() / 2));
    }
}
