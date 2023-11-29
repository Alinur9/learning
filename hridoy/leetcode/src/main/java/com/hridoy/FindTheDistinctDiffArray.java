package com.hridoy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class FindTheDistinctDiffArray {
    public int[] distinctDifferenceArray(int[] nums) {
        int[] distDiff = new int[nums.length];

        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> set2;
        for(int i=0;i< nums.length;i++){
            set2 = new HashSet<>();
            set.add(nums[i]);
            for(int j = i+1; j< nums.length;j++){
                set2.add(nums[j]);
            }
            distDiff[i] = set.size() - set2.size();
        }
return distDiff;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3,4,2};
        FindTheDistinctDiffArray obj = new FindTheDistinctDiffArray();
        System.out.println(Arrays.toString(obj.distinctDifferenceArray(nums)));
    }
}
