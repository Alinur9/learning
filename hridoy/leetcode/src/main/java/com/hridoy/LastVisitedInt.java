package com.hridoy;

import java.util.ArrayList;
import java.util.List;

public class LastVisitedInt {
    public List<Integer> lastVisitedIntegers(List<String> words) {
        List<Integer> visitedIntegers = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        int k = 0;

        for (String word : words) {
            if (word.equals("prev")) {
                if (k >= visitedIntegers.size()) {
                    result.add(-1);
                } else {
                    int lastVisited = visitedIntegers.get(visitedIntegers.size() - 1 - k);
                    result.add(lastVisited);
                }
                k++;
            } else {
                int num = Integer.parseInt(word);
                visitedIntegers.add(num);
                k = 0;
            }
        }

        return result;
    }
    public static void main(String[] args) {
List<String> words = new ArrayList<>();
words.add("1");
words.add("2");
words.add("prev");
words.add("prev");
words.add("prev");
LastVisitedInt obj = new LastVisitedInt();
        System.out.println(obj.lastVisitedIntegers(words));

    }
}
