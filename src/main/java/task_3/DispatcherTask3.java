package task_3;

public class DispatcherTask3 {
    public static void main(String[] args) {
        double[] array1 = {5, 9, 3, 2, 0, -4, -8.3, 3, -4};
        int[] array2 = {1, 6, 3, 3, 4, 5, 5, 6, 0};
        String[] array3 = {"12", "23", "34", "12", "56", "67"};

        System.out.println(ArrayController.findMax(array1));
        ArrayController.showWithoutDuplicates(array2);
        View.showArray(ArrayController.replaceToString(array3));
        ArrayController.showReversed(array2);
    }
}
