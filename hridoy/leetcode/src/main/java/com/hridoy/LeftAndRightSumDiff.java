package com.hridoy;

import java.util.Arrays;

public class LeftAndRightSumDiff {
    public int[] leftRigthDifference(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 0;
        int m = nums.length-1;
        right[m] = 0;

        for (int i =0;i<n-1;i++){
            left[i+1] = nums[i] + left[i];
            right[m-1] = nums[m] + right[m];
            m--;
        }
        for(int i=0;i<n;i++){
            ans[i] = Math.abs(left[i] - right[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        LeftAndRightSumDiff obj = new LeftAndRightSumDiff();
        System.out.println(Arrays.toString(obj.leftRigthDifference(nums)));
    }
}
