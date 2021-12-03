package Util;

import java.awt.*;

/**
 * @author Thomas Kwashnak
 */
public class Vector extends VectorFactory {

    private double x, y;

    public Vector() {
        this(0, 0);
    }

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector(Point point) {
        this(point.x,point.y);
    }

    public Vector(Vector clone) {
        this.x = clone.x;
        this.y = clone.y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Vector get() {
        return this;
    }

    public Vector add(double magnitude) {
        return add(getUnit().getMultiply(magnitude));
    }

    public Vector add(VectorFactory other) {
        Vector addVector = other.get();
        x += addVector.x;
        y += addVector.y;
        return this;
    }

    public Vector inverse() {
        x *= -1;
        y *= -1;
        return this;
    }

    public Vector subtract(double magnitude) {
        return subtract(getUnit().getMultiply(magnitude));
    }

    public Vector subtract(VectorFactory other) {
        Vector subtractVector = other.get();
        x -= subtractVector.x;
        y -= subtractVector.y;
        return this;
    }

    public Vector multiply(double scale) {
        x *= scale;
        y *= scale;
        return this;
    }

    public Vector multiply(VectorFactory scale) {
        Vector scaleVector = scale.get();
        x *= scaleVector.x;
        y *= scaleVector.y;
        return this;
    }

    public Vector divide(VectorFactory scale) {
        Vector scaleVector = scale.get();
        y /= scaleVector.y;
        x /= scaleVector.x;
        return this;
    }

    public Vector unit() {
        return divide(magnitude());
    }

    public Vector divide(double scale) {
        y /= scale;
        x /= scale;
        return this;
    }

    public Vector absolute() {
        x = Math.abs(x);
        y = Math.abs(y);
        return this;
    }

    public double magnitude() {
        return Math.sqrt(x * x + y * y);
    }

    public boolean equals(Object other) {
        return other instanceof Vector && ((Vector) other).x == x && ((Vector) other).y == y;
    }

    @Override
    public Vector clone() {
        return new Vector(x, y);
    }

    public Point toPoint() {
        return new Point((int) x, (int) y);
    }

    public String toString() {
        return "(" + x + ',' + y + ')';
    }

    public Vector set(double x, double y) {
        this.x = x;
        this.y = y;
        return this;
    }
}
