package Interfaces;

import Util.Vector;
import Util.VectorFactory;

/**
 * Provides access to the method {@link #containsPoint(Vector)}
 */
public interface ContainsPoint {

    /**
     * Checks whether a given point is contained within the bounds of the class.
     * @param point The (x,y) position to check if it is in the object's bounds
     * @return {@code true} if the point is contained within the object's bounds. {@code false} if the point is not found within the object's bounds
     */
    boolean containsPoint(Vector point);
}
