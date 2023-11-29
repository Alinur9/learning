package com.hridoy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SplitWithMinimumSum {
    public int splitNum(int num) {
        int[] count = new int[10];
        for (char c : String.valueOf(num).toCharArray()) {
            count[c - '0']++;
        }
        int[] num1Count = new int[10];
        int[] num2Count = new int[10];
        int minSum = Integer.MAX_VALUE;
        backtrack(num, 0, count, num1Count, num2Count, 0, 0, minSum);
        return minSum;
    }

    private void backtrack(int num, int idx, int[] count, int[] num1Count, int[] num2Count, int num1Sum, int num2Sum, int minSum) {
        if (idx == String.valueOf(num).length()) {
            if (isPermutation(num1Count, num2Count)) {
                int sum = num1Sum + num2Sum;
                minSum = Math.min(minSum, sum);
            }
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (count[i] > 0) {
                count[i]--;
                num1Count[i]++;
                backtrack(num, idx + 1, count, num1Count, num2Count, num1Sum + i * (int) Math.pow(10, String.valueOf(num).length() - idx - 1), num2Sum, minSum);
                num1Count[i]--;
                num2Count[i]++;
                backtrack(num, idx + 1, count, num1Count, num2Count, num1Sum, num2Sum + i * (int) Math.pow(10, idx), minSum);
                num2Count[i]--;
                count[i]++;
            }
        }
    }

    private boolean isPermutation(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }




        public static void main(String[] args) {
        int nums = 4325;
        SplitWithMinimumSum obj = new SplitWithMinimumSum();
        System.out.println(obj.splitNum(nums));

    }
}
