package com.hridoy;

import java.util.Arrays;

public class FindMaxOfStrNumPairs {
    public int maximumNumberOfStringPairs(String[] words) {
        int count=0;
        for (int i=0;i < words.length;i++){
            String input = words[i];
            char[] charArray = input.toCharArray();
            Arrays.sort(charArray);
            String sortedString = new String(charArray);
            for(int j=i+1;j< words.length;j++){
                String input2 = words[j];
                char[] charArray2 = input2.toCharArray();
                Arrays.sort(charArray2);
                String sortedString2 = new String(charArray2);
                if(sortedString2.equals(sortedString)){
                    count++;
                }
            }
        }
return count;
    }
    public static void main(String[] args) {
    String [] words = {"cd","ac","dc","ca","zz"};
    FindMaxOfStrNumPairs obj = new FindMaxOfStrNumPairs();
        System.out.println(obj.maximumNumberOfStringPairs(words));
    }
}
