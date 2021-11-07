package Menu;

import Util.Drawable;
import Game.Hitbox;
import UI.Text;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.HashMap;

public class MenuOption extends Text implements Drawable, Hitbox {

    private boolean selected = false;
    private Color colorSelected;
    private Rectangle2D bounds;
    private HashMap<Direction,MenuOption> neighbors;
    private ClickAction action;

    public MenuOption(String text, Font font, Color color, Color colorSelected) {
        this(text,font,color,colorSelected,new Point(0,0));
    }

    public MenuOption(String text, Font font, Color color, Color colorSelected, ClickAction action) {
        this(text,font,color,colorSelected,new Point(0,0),action);
    }

    public MenuOption(String text, Font font, Color color, Color colorSelected, Point position) {
        this(text,font,color,colorSelected,position,null);
    }

    public MenuOption(String text, Font font, Color color, Color colorSelected, Point position, ClickAction action) {
        super(text, font, color, position);
        this.colorSelected = colorSelected;
        neighbors = new HashMap<>();
        this.action = action;
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

    public void selectNeighbor(Direction direction) {
        if(selected) {
            setSelected(false);
            neighbors.getOrDefault(direction,this).setSelected(true);
        }
    }

    public void click() {
        if(action != null) {
            action.execute();
        }
    }

    public void setNeighborItem(MenuOption menuOption, Direction direction) {
        neighbors.put(direction,menuOption);
    }

    public Rectangle2D getBounds() {
        return bounds;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        bounds = g.getFontMetrics().getStringBounds(text,g);
        Point pos = getPosition();
        bounds.setRect(pos.x - bounds.getWidth() / 2, pos.y - bounds.getHeight() / 2, bounds.getWidth(), bounds.getHeight());
    }

    public interface ClickAction {
        void execute();
    }
}
