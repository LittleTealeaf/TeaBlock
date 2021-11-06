package Menu;

import Engine.Drawable;
import Engine.Updatable;
import UI.Scaler;
import UI.Text;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class MenuOption extends Text implements Drawable {

    private boolean selected = false;
    private Color colorSelected;
    private Rectangle2D bounds;

    public MenuOption(String text, Font font, Color color, Color colorSelected) {
        super(text,font,color,new Point(0,0));
        this.colorSelected = colorSelected;
    }

    public MenuOption(String text, Font font, Color color, Color colorSelected, Point position) {
        super(text, font, color, position);
        this.colorSelected = colorSelected;
    }

    @Override
    public Color getColor() {
        return selected ? colorSelected : color;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public Color getColorSelected() {
        return colorSelected;
    }

    public void setColorSelected(Color colorSelected) {
        this.colorSelected = colorSelected;
    }

    public boolean inBounds(Point p) {
        return bounds != null && bounds.contains(p);
    }

    public void setNeighborItem(MenuOption menuOption, Direction direction) {

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        bounds = g.getFontMetrics().getStringBounds(text,g);
    }

    public interface function {
        void execute();
    }
}
