package com.hridoy;

import java.util.Arrays;

public class MaximizeSumWithKElements {
    public int maximizeSum(int[] nums, int k) {
        int max =0;
        while(k!=0){
            Arrays.sort(nums);
            max += nums[nums.length-1];
            nums[nums.length-1] = nums[nums.length-1] +1;
            k--;
        }
return max;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int k =3;
        MaximizeSumWithKElements obj = new MaximizeSumWithKElements();
        System.out.println(obj.maximizeSum(nums,k));
    }
}
