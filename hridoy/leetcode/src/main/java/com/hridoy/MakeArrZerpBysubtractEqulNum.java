package com.hridoy;


import java.util.Arrays;

public class MakeArrZerpBysubtractEqulNum {
    public int minimumOperations(int[] nums) {

        Arrays.sort(nums);
        int min =0;
        for (int i =0; i < nums.length;i++){
            if (nums[i] == 0){
                continue;
            }
            int nonZero = nums[i];
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] != 0)
                    nums[j]=  nums[j] - nonZero;

            }
            min ++;
        }

        return min ;
    }

    public static void main(String[] args) {

        int[] nums = {1,5,0,3,5};
        MakeArrZerpBysubtractEqulNum obj = new MakeArrZerpBysubtractEqulNum();
        System.out.println(obj.minimumOperations(nums));


    }
}
