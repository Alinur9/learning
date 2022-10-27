package com.hridoy;

import java.util.ArrayList;
import java.util.List;

public class LargeNumAfterDgtSwaps {
    public int largestInteger(int num) {
        char[] chars = Integer.toString(num).toCharArray();

        int n = chars.length;
        int left =0;
        int right =0;

        for (int i = 0 ; i < n-1; i++){
            for (int j = i+1;j < n ;j++) {
                if (Character.getNumericValue(chars[i]) % 2 == 0 && Character.getNumericValue(chars[j]) % 2 == 0 && Character.getNumericValue(chars[j]) > Character.getNumericValue(chars[i])) {
                    char temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                }
                else if ( Character.getNumericValue(chars[i]) % 2 != 0 && Character.getNumericValue(chars[j]) % 2 != 0 && Character.getNumericValue(chars[j]) > Character.getNumericValue(chars[i])){
                    char temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                }
            }
            }
        return Integer.valueOf(new String(chars));
        }


    public static void main(String[] args) {
        int num = 1234;
        LargeNumAfterDgtSwaps obj = new LargeNumAfterDgtSwaps();
        obj.largestInteger(num);
        System.out.println(obj.largestInteger(num));
    }
}
