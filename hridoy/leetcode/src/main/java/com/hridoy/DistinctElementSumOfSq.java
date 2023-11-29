package com.hridoy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DistinctElementSumOfSq {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        int result = 0;

        for (int i = 0; i < n; i++) {
            Set<Integer> uniqueValues = new HashSet<>();
            for (int j = i; j < n; j++) {
                uniqueValues.add(nums.get(j));
                result += Math.pow(uniqueValues.size(), 2);
            }
        }

        return result;


    }
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(1);
        DistinctElementSumOfSq obj = new DistinctElementSumOfSq();
        System.out.println(obj.sumCounts(nums));
    }
}
