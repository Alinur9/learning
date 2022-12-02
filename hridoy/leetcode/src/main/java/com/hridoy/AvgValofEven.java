package com.hridoy;

public class AvgValofEven {
    public int averageValue(int[] nums) {
        int sum =0;
        int cou =0;
        for (int i =0 ;i < nums.length;i++){
            if (nums[i] %3 == 0 && nums[i] %2 == 0){
                sum+= nums[i];
                cou++;
            }
        }
        if(sum == 0){
            return 0;
        }
        int ans = sum/cou;
        return ans;

    }

    public static void main(String[] args) {
        int[] nums = {1,2,4,7,10};
        AvgValofEven obj = new AvgValofEven();
        System.out.println(obj.averageValue(nums));
    }
}
