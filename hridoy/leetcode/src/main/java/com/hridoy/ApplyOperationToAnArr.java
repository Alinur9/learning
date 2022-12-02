package com.hridoy;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ApplyOperationToAnArr {
    public int[] applyOperations(int[] nums) {

//        int[] nums = new int[nums.length];

        for (int i = 0; i < nums.length-1;i++){
            if (nums[i] == nums[i+1]){
                nums[i] = nums[i]*2;
                nums[i+1] =0;
            }
        }
        for (int i = 0; i < nums.length;i++){
            if (nums[i] ==0) {
                for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] != 0){
                    int temp =0 ;
                    nums[i] = nums[j];
                    nums[j] = temp;
                    break;

                }

                }
            }
        }
        return nums;

    }

    public static void main(String[] args) {
        int [] nums = {0,1};
        ApplyOperationToAnArr obj = new ApplyOperationToAnArr();
        System.out.println(Arrays.toString(obj.applyOperations(nums)));
    }
}
