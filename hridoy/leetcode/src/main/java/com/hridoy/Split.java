package com.hridoy;

import java.util.ArrayList;
import java.util.List;

public class Split {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> result = new ArrayList<>();

        for (String word : words) {
            String[] splitWords = word.split("\\" + separator); // Escape the separator character in the regular expression
            for (String splitWord : splitWords) {
                if (!splitWord.isEmpty()) {
                    result.add(splitWord);
                }
            }
        }

        return result;
    }
    public static void main(String[] args) {
        List<String> words1 = List.of("one.two.three", "four.five", "six");
char sep = '.';
Split obj = new Split();
        System.out.println(obj.splitWordsBySeparator(words1,sep));
    }
}
