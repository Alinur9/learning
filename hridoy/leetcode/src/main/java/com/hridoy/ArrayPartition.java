package com.hridoy;

import java.util.Arrays;

public class ArrayPartition  {
    public int arrayPairSum(int[] nums){
        int sum =0;
        Arrays.sort(nums);
        for(int i =0;i<nums.length;i+=2){
            sum += Math.min(nums[i],nums[i+1] );
        }
        return sum;

    }
    public static void main(String[] args) {
        int[] nums = {6,2,6,5,1,2};
        ArrayPartition obj = new ArrayPartition();
        System.out.println(obj.arrayPairSum(nums));
    }
}
