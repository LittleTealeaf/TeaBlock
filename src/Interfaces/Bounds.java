package Interfaces;

import Util.Vector;
import Util.VectorFactory;

/**
 * An interface representing an object as having a bound, or a "hit-box" in a way. Provides access to the position and dimensions of the square
 * hit-box
 *
 * @author Thomas Kwashnak
 */
public interface Bounds extends ContainsPoint {

    VectorFactory getPosition();
    VectorFactory getDimension();
}
