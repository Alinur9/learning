package com.hridoy;

import java.util.Arrays;

public class MaximumNumOfPairsInArr {
    public int[] numberOfPairs(int[] nums) {
        int [] ans ={0,1};
        if (nums.length == 1){
            return ans;
        }
        int countPairs =0;
        int leftover ;

        for (int i =0;i< nums.length;i++){

            for (int j =i+1; j <nums.length;j++){
                if (nums[i] != -1 && nums[i] == nums[j]){
                    countPairs++;
                    nums[j] = -1;
                    break;
                }
            }
        }
        leftover = nums.length - (countPairs*2);
        ans[0] = countPairs;
        ans[1]= leftover;
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {1,3,2,1,3,2,2,2};

                MaximumNumOfPairsInArr obj = new MaximumNumOfPairsInArr();
        System.out.println(Arrays.toString(obj.numberOfPairs(nums)));
    }
}
