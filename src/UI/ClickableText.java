package UI;

import Interfaces.Clickable;
import Util.Vector;
import Util.VectorFactory;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.awt.event.MouseEvent;

public class ClickableText extends BoundedText implements Clickable {

    private Runnable function;

    public ClickableText(String text, VectorFactory position, Font font, Color color, Runnable function) {
        this(text, position, Corner.TOP_LEFT, font, color, function);
    }

    public ClickableText(String text, VectorFactory position, Corner anchor, Font font, Color color, Runnable function) {
        super(text,position,anchor,font,color);
        this.function = function;
    }

    @Override
    public void mouseClicked(@NotNull MouseEvent e) {
        if(containsPoint(new Vector(e.getPoint()))) {
            run();
        }
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    public void setFunction(Runnable function) {
        this.function =function;
    }

    public Runnable getFunction() {
        return function;
    }

    @Override
    public void run() {
        if(function != null) {
            function.run();
        }
    }
}
