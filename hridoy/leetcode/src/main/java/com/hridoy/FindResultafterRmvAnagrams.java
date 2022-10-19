package com.hridoy;

import java.util.*;

public class FindResultafterRmvAnagrams {
    public List<String> removeAnagrams(String[] words) {
        List<String>  list = new ArrayList<>();
        list.add(words[0]);
            for (int j = 1; j < words.length;j++) {

                char[] charArray1 = words[j].toCharArray();
                char[] charArray2 = words[j-1].toCharArray();
                Arrays.sort(charArray1);
                Arrays.sort(charArray2);
                if (!Arrays.equals(charArray1, charArray2)) {

                    list.add(words[j]);
                }

            }
        return list;


    }
    public static void main(String[] args) {

        String[] words = {"abba","baba","bbaa","cd","cd"};
        FindResultafterRmvAnagrams obj = new FindResultafterRmvAnagrams();
        System.out.println(obj.removeAnagrams(words));

    }
}
