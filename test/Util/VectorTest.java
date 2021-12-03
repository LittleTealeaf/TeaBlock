package Util;

import junit.framework.TestCase;

import java.awt.*;

import static TestUtil.RandomGenerator.*;
import static org.junit.Assert.assertNotEquals;
import static TestUtil.Approximation.*;

/**
 * Each method lists prerequisite tests in the "See also" list. This list contains the list of methods that must pass in order to validate the
 * passing or failure of this test. In the case of a loop, if all tests pass, then all passes are valid
 */
public class VectorTest extends TestCase {

    /**
     * Tests that an empty vector's values are set to 0
     * @see #testGetX()
     * @see #testGetY()
     */
    public void testConstructorEmpty() {
        testGetX();
        testGetY();

        Vector vector = new Vector();
        assertEquals(0.0,vector.getX());
        assertEquals(0.0,vector.getY());
    }

    public void testConstructorPoint() {
        testGetX();
        testGetY();

        Point point = randomPoint();
        Vector vector = new Vector(point);
        assertEquals(point.x,(int) vector.getX());
        assertEquals(point.y,(int) vector.getY());
    }

    /**
     * @see #testGetY()
     * @see #testGetX()
     */
    public void testConstructorNotEmpty() {
        double x = randomDouble(), y = randomDouble();
        Vector vector = new Vector(x,y);
        assertEquals(x,vector.getX());
        assertEquals(y,vector.getY());
    }

    /**
     * @see #testConstructorNotEmpty()
     */
    public void testGetX() {
        testConstructorNotEmpty();

        double x = randomDouble();
        Vector vector = new Vector(x,0);
        assertEquals(x,vector.getX());
    }

    /**
     * @see #testConstructorNotEmpty()
     */
    public void testGetY() {
        testConstructorNotEmpty();

        double y = randomDouble();
        Vector vector = new Vector(0,y);
        assertEquals(y,vector.getY());
    }


    /**
     * @see #testGetX()
     */
    public void testSetX() {
        testGetX();
        Vector vector = new Vector();
        double x = randomDouble();
        vector.setX(x);
        assertEquals(x,vector.getX());
    }

    /**
     * @see #testGetY()
     */
    public void testSetY() {
        testGetY();

        Vector vector = new Vector();
        double y = randomDouble();
        vector.setY(y);
        assertEquals(y,vector.getY());
    }

    public void testGet() {
        Vector vector = randomVector();
        assertSame(vector,vector.get());
    }

    /**
     * @see #testEquals()
     */
    public void testClone() {
        testEquals();

        Vector vector = randomVector();
        Vector clone = vector.clone();
        assertEquals(vector,clone);
        assertNotSame(vector, clone);
    }

    /**
     * @see #testGetX()
     * @see #testGetY()
     * @see #testClone()
     */
    public void testAddVector() {
        testGetX();
        testGetY();
        testClone();

        Vector a = randomVector(), b = randomVector();
        Vector ac = a.clone();
        Vector an = a.add(b);
        assertSame(a,an);
        assertEquals(ac.getX() + b.getX(),a.getX());
        assertEquals(ac.getY() + b.getY(),a.getY());
    }

    /**
     * @see #testUnit()
     * @see #clone()
     * @see #testMagnitude()
     * @see #testGetX()
     * @see #testGetY()
     */
    public void testAddMagnitude() {
        testUnit();
        testClone();
        testMagnitude();
        testGetX();
        testGetY();

        Vector a = randomVector();
        Vector ac = a.clone();
        double magnitude = randomDouble();
        Vector unit = a.clone().unit();
        Vector add = unit.multiply(magnitude);
        Vector an = a.add(magnitude);
        assertSame(a,an);
        assertEquals(ac.getX() + add.getX(), a.getX());
        assertEquals(ac.getY() + add.getY(), a.getY());
    }

    /**
     * @see #testGetY()
     * @see #testGetX()
     * @see #clone()
     */
    public void testInverse() {
        testGetY();
        testGetX();
        testClone();

        Vector a = randomVector();
        Vector ac = a.clone();
        Vector an = a.inverse();
        assertSame(a,an);
        assertEquals(-ac.getX(),a.getX());
        assertEquals(-ac.getY(),a.getY());
    }

    /**
     * @see #testGetX()
     * @see #testGetY()
     * @see #testClone()
     */
    public void testSubtractVector() {
        testGetX();
        testGetY();
        testClone();

        Vector a = randomVector(), b = randomVector();
        Vector ac = a.clone();
        Vector an = a.subtract(b);
        assertSame(a,an);
        assertEquals(ac.getX() - b.getX(), a.getX());
        assertEquals(ac.getX() - b.getX(), a.getX());
    }

    /**
     * @see #testGetX()
     * @see #testGetY()
     * @see #testClone()
     * @see #testUnit()
     * @see #testMultiplyMagnitude()
     */
    public void testSubtractMagnitude() {
        testGetX();
        testGetY();
        testClone();
        testUnit();
        testMultiplyMagnitude();

        Vector a = randomVector();
        Vector ac = a.clone();
        double magnitude = randomDouble();
        Vector unit = a.clone().unit();
        Vector add = unit.multiply(magnitude);
        Vector an = a.subtract(magnitude);
        assertSame(a,an);
        assertEquals(ac.getX() - add.getX(), a.getX());
        assertEquals(ac.getY() - add.getY(), a.getY());
    }

    /**
     * @see #testGetX()
     * @see #testGetY()
     * @see #testClone()
     */
    public void testMultiplyMagnitude() {
        testGetX();
        testGetY();
        testClone();

        Vector a = randomVector();
        Vector ac = a.clone();
        double magnitude = randomDouble();
        Vector an = a.multiply(magnitude);
        assertSame(a,an);
        assertEquals(ac.getX() * magnitude,a.getX());
        assertEquals(ac.getY() * magnitude,a.getY());
    }

    /**
     * @see #testClone()
     * @see #testGetX()
     * @see #testGetY()
     */
    public void testMultiplyVector() {
        testClone();
        testGetX();
        testGetY();

        Vector a = randomVector(), b = randomVector();
        Vector ac = a.clone();
        Vector an = a.multiply(b);
        assertSame(a,an);
        assertEquals(ac.getX() * b.getX(),a.getX());
        assertEquals(ac.getY() * b.getY(), a.getY());
    }

    /**
     * @see #testClone()
     * @see #testGetX()
     * @see #testGetY()
     */
    public void testDivideMagnitude() {
        testClone();
        testGetX();
        testGetY();

        Vector a = randomVector();
        Vector ac = a.clone();
        double magnitude = randomDouble();
        Vector an = a.divide(magnitude);
        assertSame(a,an);
        assertEquals(ac.getX() / magnitude,a.getX());
        assertEquals(ac.getY() / magnitude,a.getY());
    }

    /**
     * @see #testClone()
     * @see #testGetX()
     * @see #testGetY()
     */
    public void testDivideVector() {
        testClone();
        testGetX();
        testGetY();

        Vector a = randomVector(), b = randomVector();
        Vector ac = a.clone();
        Vector an = a.divide(b);
        assertSame(a,an);
        assertEquals(ac.getX() / b.getX(),a.getX());
        assertEquals(ac.getY() / b.getY(), a.getY());
    }

    /**
     * @see #testGetY()
     * @see #testGetX()
     */
    public void testMagnitude() {
        testGetX();
        testGetY();

        Vector a = randomVector();
        double magnitude = Math.sqrt(a.getX() * a.getX() + a.getY() * a.getY());
        assertEquals(magnitude,a.magnitude());
    }

    /**
     * @see #testClone()
     * @see #testMagnitude()
     * @see #testGetX()
     * @see #testGetY()
     */
    public void testUnit() {
        testClone();
        testMagnitude();
        testGetX();
        testGetY();

        Vector a = randomVector();
        Vector ac = a.clone();
        double magnitude = a.magnitude();
        Vector an = a.unit();
        assertSame(a,an);
        assertTrue(Math.abs(a.magnitude() - 1) < 0.1);
        assertTrue(aboutEquals(magnitude,ac.getY() / a.getY()));
        assertTrue(aboutEquals(magnitude,ac.getX() / a.getX()));

    }

    public void testEquals() {
        double x = randomDouble();
        double y = randomDouble();
        Vector a = new Vector(x,y), b = new Vector(x,y), c = randomVector();
        assertEquals(a,b);
        assertNotEquals(a,c);
    }

    public void testAbsolute() {
        testGetX();
        testGetY();
        testClone();

        Vector a = randomVector();
        Vector ac = a.clone();
        Vector an = a.absolute();
        assertSame(a,an);
        assertEquals(Math.abs(ac.getX()),a.getX());
        assertEquals(Math.abs(ac.getY()),a.getY());
    }

    public void testSet() {
        testGetX();
        testGetY();
        testConstructorEmpty();

        double x = randomDouble(), y = randomDouble();
        Vector a = new Vector();
        Vector ac = a.set(x,y);
        assertSame(a,ac);
        assertEquals(x,a.getX());
        assertEquals(y,a.getY());
    }
}