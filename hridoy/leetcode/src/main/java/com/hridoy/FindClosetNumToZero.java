package com.hridoy;

import java.util.Arrays;

public class FindClosetNumToZero {
    public int findClosestNumber(int[] nums) {
        int count = 0;
        int closest =0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length ; i++) {
            if(nums[i] == 0){
                return 0;
            }
            if (closest == 0) {
                closest = nums[i];
            }
            if (nums[i] > 0 && nums[i] <= Math.abs(closest)) {
                closest = nums[i];
            } else if (nums[i] < 0 &&  nums[i] < Math.abs(closest)) {
                closest = nums[i];
            }
        }
        if (closest >= 0) {
            while (closest != 0) {
                closest--;
                count++;
            }
            return count;

        }
            if (closest <= 0) {
                int temp = closest;
                while (closest != 0) {
                    closest++;

                }
                return temp;
            }


        return count;
        }



    public static void main(String[] args) {

        FindClosetNumToZero obj = new FindClosetNumToZero();
        int[] nums ={-4,-2,1,4,8};
        System.out.println(obj.findClosestNumber(nums));

    }
}
