package com.hridoy;

import java.util.Arrays;

public class CheckIfArraIsGood {
    public boolean isGood(int[] nums) {

        Arrays.sort(nums);

        for (int i =0;i< nums.length-2;i++){
            if(nums[i] != i+1){
                return false;
            }
        }
        return nums[nums.length-1] == nums.length-1 && nums[nums.length-2] == nums.length-1;
    }

    public static void main(String[] args) {

        int[] nums ={1, 3, 3, 2};
        CheckIfArraIsGood obj = new CheckIfArraIsGood();
        System.out.println(obj.isGood(nums));

    }
}
