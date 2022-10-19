package com.hridoy;

public class MaximumProductDiff {
    public int maxProductDifference(int[] nums) {

        int max = nums[0] ;
        int min = nums[0] * nums[1] ;

        int productDiff =0;
        for (int i =0; i < nums.length ; i++){
            for (int j =i+1 ; j < nums.length ; j++){
                max = Math.max(max , nums[i] * nums[j] );
                min = Math.min(min,nums[i] * nums[j] );

            }


        }

        productDiff = max-min;

        return productDiff;

    }



    public static void main(String[] args) {
        int[] nums = {5,6,2,7,4};
        MaximumProductDiff obj = new MaximumProductDiff();
        System.out.println(obj.maxProductDifference(nums));

    }
}
