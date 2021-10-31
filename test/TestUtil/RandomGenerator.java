package TestUtil;

public class RandomGenerator {

    public static int randomInt() {
        return randomInt(0,100);
    }

    public static int randomInt(int high) {
        return randomInt(0,high);
    }

    public static int randomInt(int low, int high) {
        return (int) (Math.random() * (high - low) + low);
    }

    public static int[] randomIntArray(int length, int low, int high) {
        int[] array = new int[length];
        for(int i = 0; i < length; i++) {
            array[i] = randomInt(low,high);
        }
        return array;
    }

    public static int[] randomIntArray(int length) {
        return randomIntArray(length,0,100);
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

    public static int[][] randomIntMatrix(int height, int length) {
        return randomIntMatrix(height,length,0,100);
    }

}
