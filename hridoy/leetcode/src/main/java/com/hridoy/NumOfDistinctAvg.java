package com.hridoy;

import java.util.ArrayList;
import java.util.List;

public class NumOfDistinctAvg {
    public int distinctAverages(int[] nums) {
        List<Float> list = new ArrayList<>();
        float sum;
        int count =0 ;
        int min = 101;
        int max = 0;
        int trackMax = 0;
        int trackMin = 0 ;
        for ( int i = 0; i < nums.length/2;i++){
            for (int j =0; j < nums.length;j++){
                if (max < nums[j] && nums[j] != -1){
                    max = nums[j];
                    trackMax = j;
                }
                if (min > nums[j] && nums[j] != -1 ){
                    min = nums[j];
                    trackMin = j;
                }
            }
            nums[trackMax] = -1;
            nums[trackMin] = -1;
            sum = (float) (min + max)/2;
            if (!list.contains(sum)){
                list.add(sum);
                count++;

            }
            min = 101;
            max = 0;

        }
        return count;
    }

    public static void main(String[] args) {
        int [] nums = {9,5,7,8,7,9,8,2,0,7};
        NumOfDistinctAvg obj = new NumOfDistinctAvg();
        System.out.println(obj.distinctAverages(nums));
    }
}
