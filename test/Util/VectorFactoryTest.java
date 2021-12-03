package Util;

import junit.framework.TestCase;

import static TestUtil.RandomGenerator.randomDouble;
import static TestUtil.RandomGenerator.randomVector;

public class VectorFactoryTest extends TestCase {


    public void testGetAddVector() {

        Vector a = randomVector(), b = randomVector();
        Vector ac = a.clone(), bc = b.clone();

        VectorFactory factory = a.getAdd(b);
        assertEquals(a,ac);
        assertEquals(b,bc);
        assertEquals(new Vector(ac.getX() + bc.getX(),ac.getY() + bc.getY()), factory.get());
        assertEquals(a,ac);
        assertEquals(b,bc);
    }

    public void testGetSubtractVector() {
        Vector a = randomVector(), b = randomVector();
        Vector ac = a.clone(), bc = b.clone();

        VectorFactory factory = a.getSubtract(b);
        assertEquals(a,ac);
        assertEquals(b,bc);
        assertEquals(ac.clone().subtract(b),factory.get());
        assertEquals(a,ac);
        assertEquals(b,bc);
    }

    public void testGetAddMagnitude() {
        Vector a = randomVector();
        Vector ac = a.clone();
        double magnitude = randomDouble();

        VectorFactory factory = a.getAdd(magnitude);
        assertEquals(a,ac);
        assertEquals(ac.clone().add(magnitude),factory.get());
        assertEquals(a,ac);
    }

    public void testGetSubtractMagnitude() {
        Vector a = randomVector();
        Vector ac = a.clone();
        double magnitude = randomDouble();

        VectorFactory factory = a.getSubtract(magnitude);
        assertEquals(a,ac);
        assertEquals(ac.clone().subtract(magnitude),factory.get());
        assertEquals(a,ac);
    }

    public void testGetInverse() {
        Vector a = randomVector();
        Vector ac = a.clone();
        VectorFactory factory = a.getInverse();
        assertEquals(a,ac);
        assertEquals(-ac.getX(),factory.get().getX());
        assertEquals(-ac.getY(),factory.get().getY());
        assertEquals(a,ac);
    }

    public void testGetMultiplyMagnitude() {
        Vector a = randomVector();
        Vector ac = a.clone();
        double magnitude = randomDouble();

        VectorFactory factory = a.getMultiply(magnitude);
        assertEquals(a,ac);
        assertEquals(ac.clone().multiply(magnitude),factory.get());
        assertEquals(a,ac);
    }

    public void testGetMultiplyVector() {
        Vector a = randomVector(), b = randomVector();
        Vector ac = a.clone(), bc = b.clone();

        VectorFactory factory = a.getMultiply(b);
        assertEquals(a,ac);
        assertEquals(b,bc);
        assertEquals(ac.clone().multiply(b),factory.get());
        assertEquals(a,ac);
        assertEquals(b,bc);
    }

    public void testGetDivideMagnitude() {
        Vector a = randomVector();
        Vector ac = a.clone();
        double magnitude = randomDouble();

        VectorFactory factory = a.getDivide(magnitude);
        assertEquals(a,ac);
        assertEquals(ac.clone().divide(magnitude),factory.get());
        assertEquals(a,ac);
    }

    public void testGetDivideVector() {
        Vector a = randomVector(), b = randomVector();
        Vector ac = a.clone(), bc = b.clone();

        VectorFactory factory = a.getDivide(b);
        assertEquals(a,ac);
        assertEquals(b,bc);
        assertEquals(ac.clone().divide(b),factory.get());
        assertEquals(a,ac);
        assertEquals(b,bc);
    }

    public void testGetUnit() {
        Vector a = randomVector();
        Vector ac = a.clone();

        VectorFactory factory = a.getUnit();
        assertEquals(a,ac);
        assertEquals(ac.clone().unit(),factory.get());
        assertEquals(a,ac);
    }

    public void testGetAbsolute() {
        Vector a = randomVector();
        Vector ac = a.clone();

        VectorFactory factory = a.getAbsolute();
        assertEquals(a,ac);
        assertEquals(ac.clone().absolute(),factory.get());
        assertEquals(a,ac);
    }

}