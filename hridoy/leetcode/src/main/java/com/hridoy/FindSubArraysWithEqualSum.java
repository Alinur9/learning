package com.hridoy;

public class FindSubArraysWithEqualSum {
    public boolean findSubarrays(int[] nums) {
        int sum =0;
        int [] subArr = new int[2];
        int [] determine = new int[2];
        for (int i =0; i < nums.length-1;i++){
            subArr[0] = nums[i];
            subArr[1] = nums[i+1];
            for (int j = i+1; j < nums.length-1;j++){
                determine[0] = nums[j];
                determine[1] = nums[j+1];
                if (subArr[0] + subArr[1] == determine[0] + determine[1]){
                    return true;
                }

            }

        }
        return false;

    }


    public static void main(String[] args) {

        int[] nums = {0,0,0,1,2,3,4,5};
        FindSubArraysWithEqualSum obj = new FindSubArraysWithEqualSum();
        System.out.println(obj.findSubarrays(nums));

    }
}
