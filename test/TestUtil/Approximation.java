package TestUtil;

public class Approximation {
    public static boolean aboutEquals(double a, double b) {
        return Math.abs(a-b) < 0.0001;
    }
}
