package tasks.task_3;

import java.util.Arrays;

public class ArrayController {
    public static double findMax(double[] array) {
        double max = Double.NEGATIVE_INFINITY;
        for (double value : array) {
            if (max < value) max = value;
        }
        return max;
    }

    public static void showWithoutDuplicates(int[] array) {
        int[] result = new int[array.length];
        int resultIndex = 0;
        for (int temp : array) {
            if (!contains(result, temp)) {
                result[resultIndex++] = temp;
            }
        }
        Arrays.sort(result);
        System.out.println(Arrays.toString(result));
    }

    private static boolean contains(int[] array, int value) {
        for (int temp : array) {
            if (temp == value) return true;
        }
        return false;
    }

    public static String[] replaceToString(String[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals("12")) {
                array[i] = "replaced";
            }
        }
        return array;
    }

    public static void showReversed(int[] array) {
        for (int i = array.length - 1; i > -1; i--) {
            System.out.print(array[i] + " ");
        }
    }
}
