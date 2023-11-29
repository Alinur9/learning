package com.hridoy;

public class MountainTriplet {
    public int minimumSum(int[] nums) {
        int sum =Integer.MAX_VALUE;


        for(int i=0;i< nums.length;i++){

            for(int j=i+1;j<nums.length;j++){

                for(int k=j+1;k<nums.length;k++){

                    if(nums[i] < nums[j] && nums[k] < nums[j]){
                        int  tempSum = nums[i] + nums[k] + nums[j];
                        if(sum > tempSum){
                            sum = tempSum;
                    }
                }
            }

            }
        }
        return sum == Integer.MAX_VALUE ? -1:sum;
    }
    public static void main(String[] args) {
        int [] nums = {5,4,8,7,10,2};
        MountainTriplet obj = new MountainTriplet();
        System.out.println(obj.minimumSum(nums));
    }
}
