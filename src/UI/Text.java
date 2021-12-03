package UI;

import Interfaces.Drawable;
import Util.VectorFactory;

import java.awt.*;

public class Text implements Drawable {

    protected Integer text_height, text_width;
    protected String[] text;
    private VectorFactory position;
    private Font font;
    private Color color;
    private Corner anchor;

    public Text(String text, VectorFactory position, Font font, Color color) {
        this(text,position,Corner.TOP_LEFT,font,color);
    }

    public Text(String text, VectorFactory position, Corner anchor, Font font, Color color) {
        setText(text);
        setFont(font);
        setColor(color);
        setPosition(position);
        setAnchor(anchor);
    }

    public void setText(String... text) {
        this.text = text;
        resetWidth();
    }

    public void setFont(Font font) {
        this.font = font;
        resetHeight();
        resetWidth();
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String[] getText() {
        return text;
    }

    public VectorFactory getPosition() {
        return position;
    }

    public void setPosition(VectorFactory position) {
        this.position = position;
    }

    public Color getColor() {
        return color;
    }

    public Font getFont() {
        return font;
    }

    public void setAnchor(Corner anchor) {
        this.anchor = anchor;
    }

    public Corner getAnchor() {
        return anchor;
    }


    @Override
    public void paintComponent(Graphics g) {
        String[] printText = getText();
        if(text_height == null) {
            text_height = g.getFontMetrics(getFont()).getHeight();
        }
        if(text_width == null) {
            FontMetrics metrics = g.getFontMetrics(getFont());
            text_width = metrics.stringWidth(printText[0]);
            for(int i = 1; i < printText.length; i++) {
                text_width = Math.max(metrics.stringWidth(printText[i]),text_width);
            }
        }

        Point p = getPosition().get().toPoint();

        g.setFont(getFont());
        g.setColor(getColor());

        for(int i = 0; i < printText.length; i++) {
            g.drawString(printText[i],p.x + anchor.x * text_width,p.y + text_height * (i + anchor.y));
        }
    }

    protected void resetHeight() {
        text_height = 0;
    }

    protected void resetWidth() {
        text_width = 0;
    }

    public enum Corner {
        TOP_LEFT(0,-1),TOP_RIGHT(1,-1),BOTTOM_LEFT(0,0),BOTTOM_RIGHT(1,0);

        int x, y;
        Corner(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
