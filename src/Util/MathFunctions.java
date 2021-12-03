package Util;

public class MathFunctions {
    public static boolean inRange(double low, double high, double test) {
        return low <= test && high >= test;
    }

    public static boolean withinBounds(VectorFactory position, VectorFactory dimension, VectorFactory point) {
        Vector a = position.get();
        Vector b = a.getAdd(dimension).get();
        Vector p = point.get();
        return inRange(a.getX(),b.getX(),p.getX()) && inRange(a.getY(),b.getY(),p.getY());
    }
}
