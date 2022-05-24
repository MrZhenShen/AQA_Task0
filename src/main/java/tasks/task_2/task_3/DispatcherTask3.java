package tasks.task_2.task_3;

import java.util.*;

public class DispatcherTask3 {
    public static void main(String[] args) {
//        double[] array1 = {5, 9, 3, 2, 0, -4, -8.3, 3, -4};
//        int[] array2 = {1, 6, 3, 3, 4, 5, 5, 6, 0};
//        String[] array3 = {"12", "23", "34", "12", "56", "67"};
//
//        System.out.println(ArrayController.findMax(array1));
//        ArrayController.showWithoutDuplicates(array2);
//        View.showArray(ArrayController.replaceToString(array3));
//        ArrayController.showReversed(array2);


        List<Integer> list = Arrays.asList(1, 23, 4, 35, 4, 55, 6, 567, 67, 87, 8, 7);
        CollectionsController.replaceInFirstHalf(list, 4, 0);

        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(Arrays.asList(1, 23, 4, 35));
        matrix.add(Arrays.asList(4, 55, 6, 567));
        matrix.add(Arrays.asList(67, 87, 8, 7));
        matrix.add(Arrays.asList(2, 23, 0, 5));
        CollectionsController.matrixToString(matrix);
        CollectionsController.reverse(matrix);
        CollectionsController.matrixUniqueValues(matrix);

        String text= "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
        CollectionsController.countStartLetters(text);

        CollectionsController.testCollections();
    }
}
