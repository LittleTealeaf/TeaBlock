package Menu;

import Interfaces.Updatable;
import UI.ClickableText;
import Util.VectorFactory;

import java.awt.*;

public class MenuOption extends ClickableText {

    private Color color, colorSelected;
    private boolean selected;
    private MenuOption[] neighbors;
    private MenuOption tempNeighbor;

    public MenuOption(String text, VectorFactory position, Corner anchor, Font font, Color color, Color colorSelected, Runnable function) {
        super(text, position, anchor, font, null, function);
        neighbors = new MenuOption[] {this,this,this,this};
    }

    public void setNeighbor(MenuDirection direction, MenuOption option) {
        neighbors[direction.getIndex()] = option;
    }

    public Color getColor() {
        return selected ? colorSelected : color;
    }

}
