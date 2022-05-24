package tasks.task_2.task_3;

import java.util.*;

public class CollectionsController {
    public static void replaceInFirstHalf(List<Integer> list, int fromInteger, int toInteger) {
        for (int i = 0; i < list.size() / 2; i++) {
            if (list.get(i).equals(fromInteger)) list.set(i, toInteger);
        }
    }

    public static void reverse(List<List<Integer>> list) {
        try {
            for (int row = 0; row < list.size(); row++) {
                for (int col = 0; col < list.get(row).size(); col++) {
                    System.out.print(list.get(col).get(row) + "\t");
                }
                if (row != list.size() - 1) System.out.println();
            }
        } catch (IndexOutOfBoundsException ignored) {
            System.out.println("Amount of rows and cols in matrix are not equal");
        }
    }

    public static void matrixUniqueValues(List<List<Integer>> list) {
        Set<Integer> set = new HashSet<>();
        try {
            for (int row = 0; row < list.size(); row++) {
                for (int col = 0; col < list.get(row).size(); col++) {
                    if (set.contains(list.get(row).get(col))) list.get(row).set(col, -1);
                    else set.add(list.get(row).get(col));
                    System.out.print(list.get(row).get(col) + "\t");
                }
                if (row != list.size() - 1) System.out.println();
            }
        } catch (IndexOutOfBoundsException ignored) {
            System.out.println("Amount of rows and cols in matrix are not equal");
        }
    }

    public static void matrixToString(List<List<Integer>> list) {
        try {
            for (int row = 0; row < list.size(); row++) {
                for (int col = 0; col < list.get(row).size(); col++) {
                    System.out.print(list.get(row).get(col) + "\t");
                }
                if (row != list.size() - 1) System.out.println();
            }
        } catch (IndexOutOfBoundsException ignored) {
            System.out.println("Amount of rows and cols in matrix are not equal");
        }
    }

    public static void countStartLetters(String text) {
        Map<Character, Integer> dict = new TreeMap<>();
        String[] words = text.split(" ");
        for (String word : words) {
            dict.putIfAbsent(word.charAt(0), 0);
            dict.put(word.charAt(0), dict.get(word.charAt(0)) + 1);
        }
        System.out.println(dict);
    }

    public static void testCollections() {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            list.add("" + Math.floor(Math.random() * 10));
        }

        System.out.println("Get test: "+checkGet(list));
        System.out.println("Set test: "+checkSet(list));
    }

    private static long checkGet(List<String> list) {
        long start = new Date().getTime();
        Random rand = new Random();
        for (int i = 0; i < 10000; i++) {
            int length = list.get(rand.nextInt(list.size()-1)).length();
        }
        return new Date().getTime()-start;
    }

    private static long checkSet(List<String> list) {
        long start = new Date().getTime();
        Random rand = new Random();
        for (int i = 0; i < 10000; i++) {
            list.set(rand.nextInt(list.size()-1), "" + Math.floor(Math.random() * 10));
        }
        return new Date().getTime()-start;
    }
}
