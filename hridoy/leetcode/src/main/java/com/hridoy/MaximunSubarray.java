package com.hridoy;



public class MaximunSubarray {

    public int maxSubArray(int[] nums) {
       int curSum = nums[0];
       int maxSum = nums[0];

       for ( int i = 1; i < nums.length; i++){

           curSum = Math.max(curSum + nums[i],nums[i]);

           maxSum = Math.max(maxSum,curSum);
       }
       return maxSum;




    }
    public static void main(String[] args) {

        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        MaximunSubarray obj = new MaximunSubarray();
        System.out.println(obj.maxSubArray(nums));

    }
}
