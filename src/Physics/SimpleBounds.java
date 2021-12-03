package Physics;

import Interfaces.Bounds;
import Util.Vector;
import Util.VectorFactory;

import static Util.MathFunctions.inRange;
import static Util.MathFunctions.withinBounds;

/*
Provides a simple bounds from a given location and a dimension
 */
public class SimpleBounds implements Bounds {

    private VectorFactory position, dimension;

    public SimpleBounds() {
        this(new Vector(), new Vector(1,1));
    }

    public SimpleBounds(VectorFactory position, VectorFactory dimension) {
        this.position = position;
        this.dimension = dimension;
    }

    @Override
    public VectorFactory getPosition() {
        return position;
    }

    @Override
    public VectorFactory getDimension() {
        return dimension;
    }

    @Override
    public boolean containsPoint(Vector point) {
        return withinBounds(position,dimension,point);
    }

}
