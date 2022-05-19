package tasks.task_2;

import java.util.ArrayList;

public class StringController {

    public static int wordsAmount(String text) {
        return text.split(" ").length;
    }

    public static ArrayList<Integer> charsAmount(String text) {
        ArrayList<Integer> charsInWords = new ArrayList<>();
        String[] words = text.split(" ");
        for (String word : words) {
            charsInWords.add(word.codePointCount(0, word.length()));
        }
        return charsInWords;
    }

    public static int charsAmountByIndex(String text, int index) {
        return text.substring(index).split(" ")[0].length();
    }


}
