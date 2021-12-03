package UI;

import Interfaces.Bounds;
import Util.Vector;
import Util.VectorFactory;

import java.awt.*;

import static Util.MathFunctions.withinBounds;

public class BoundedText extends Text implements Bounds {

    private Vector dimension;

    public BoundedText(String text, VectorFactory position, Font font, Color color) {
        this(text,position,Corner.TOP_LEFT,font,color);
    }

    public BoundedText(String text, VectorFactory position, Corner anchor, Font font, Color color) {
        super(text,position,anchor,font,color);
        dimension = new Vector();
    }

    @Override
    public VectorFactory getDimension() {
        return text_height != null && text_width != null ? dimension.set(text_width,text_height) : dimension;
    }

    @Override
    public boolean containsPoint(Vector point) {
        return text_height != null && text_width != null && withinBounds(getPosition(), getDimension(), point);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
