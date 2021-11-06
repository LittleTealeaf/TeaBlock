package UI;

import java.awt.*;
import java.text.AttributedCharacterIterator;
import java.util.Map;

/**
 * An extension of the {@link Font} class to include a color variable.
 */
public class ColoredFont extends Font {

    private Color color;

    public ColoredFont(Font font, Color color) {
        super(font);
        this.color = color;
    }

    public ColoredFont(Map<? extends AttributedCharacterIterator.Attribute, ?> attributes,Color color) {
        super(attributes);
        this.color = color;
    }

    public ColoredFont(String name, int style, int size, Color color) {
        super(name,style,size);
        this.color = color;
    }

    public ColoredFont(Font font, int style, float size, Color color) {
        super(font.deriveFont(style).deriveFont(size));
        this.color = color;
    }

    public ColoredFont(Font font, float size, Color color) {
        super(font.deriveFont(size));
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
