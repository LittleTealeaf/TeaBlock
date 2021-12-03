package TestUtil;

import Util.Vector;

import java.awt.*;

public class RandomGenerator {

    public static Vector randomVector() {
        return new Vector(randomDouble(),randomDouble());
    }

    public static double randomDouble() {
        return randomDouble(-100,100);
    }

    public static double randomDouble(double low, double high) {
        return Math.round((Math.random() * (high - low) + low) * Math.log(high - low)) / Math.log(high - low);
    }

    public static Vector randomVector(double high) {
        return new Vector(randomDouble(high),randomDouble(high));
    }

    public static double randomDouble(double high) {
        return randomDouble(0,high);
    }

    public static Vector randomVector(double low, double high) {
        return new Vector(randomDouble(low,high),randomDouble(low,high));
    }

    public static int randomInt() {
        return randomInt(0,100);
    }

    public static int randomInt(int low, int high) {
        return (int) (Math.random() * (high - low) + low);
    }

    public static int randomInt(int high) {
        return randomInt(0,high);
    }

    public static int[] randomIntArray(int length) {
        return randomIntArray(length,0,100);
    }

    public static int[] randomIntArray(int length, int low, int high) {
        int[] array = new int[length];
        for(int i = 0; i < length; i++) {
            array[i] = randomInt(low,high);
        }
        return array;
    }

    public static int[][] randomIntMatrix(int height, int length) {
        return randomIntMatrix(height,length,0,100);
    }

    public static int[][] randomIntMatrix(int height, int length, int low, int high) {
        int[][] matrix = new int[height][length];
        for(int i = 0; i < length; i++) {
            for(int j = 0; j < height; j++) {
                matrix[i][j] = randomInt(low,high);
            }
        }
        return matrix;
    }

    public static Point randomPoint() {
        return randomPoint(1000);
    }

    public static Point randomPoint(int high) {
        return randomPoint(0,1000);
    }

    public static Point randomPoint(int low, int high) {
        return new Point(randomInt(low,high),randomInt(low,high));
    }

}
