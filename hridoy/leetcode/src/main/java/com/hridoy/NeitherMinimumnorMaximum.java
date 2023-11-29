package com.hridoy;

import java.util.Arrays;

public class NeitherMinimumnorMaximum {

    public int findNonMinOrMax(int[] nums) {
        if(nums.length < 3){
            return -1;
        }
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[0] != nums[i+1] && nums[nums.length-1] != nums[i+1]){
                return nums[i+1];
            }
        }

return -1;
    }

    public static void main(String[] args) {
        NeitherMinimumnorMaximum  obj = new NeitherMinimumnorMaximum() ;
        int[]nums={3,2,1,4};
        System.out.println(obj.findNonMinOrMax(nums));

    }
}
