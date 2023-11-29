package com.hridoy;

import java.util.Arrays;

public class FindIndicesWithIndex {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int[] ans  ={-1,-1};
        if(nums.length == 1 && indexDifference == 0 && valueDifference ==0){
           ans[0] =0;
                    ans[1] =0;
            return ans;
        }


        for(int i=0;i< nums.length-1;i++){
            for (int j=i+1;j< nums.length;j++){
                if(Math.abs(i - j) >= indexDifference && Math.abs(nums[i] - nums[j]) >= valueDifference){
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        FindIndicesWithIndex findIndicesWithIndex = new FindIndicesWithIndex();
        int index =2;
        int valueDiff =4;
        int[] nums = {5,1,4,1};
        System.out.println(Arrays.toString(findIndicesWithIndex.findIndices(nums, index, valueDiff)));
    }
}
