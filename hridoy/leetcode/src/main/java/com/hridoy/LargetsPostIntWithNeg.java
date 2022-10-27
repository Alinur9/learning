package com.hridoy;

public class LargetsPostIntWithNeg {
    public int findMaxK(int[] nums) {
        int max = -1;
        int pos =0;
        int neg =0;
        for (int i =0 ; i < nums.length;i++){
            if (nums[i]>0){
                pos = nums[i];
            }
            for(int j =0;j<nums.length;j++){
                if (nums[j] < 0){
                    neg =Math.abs(nums[j]);
                }
                if (pos == neg){
                    if(pos > max){
                        max = pos ;
                    }
                }

            }
        }

return max;
    }

    public static void main(String[] args) {

        int[] nums = {-1,2,-3,3};
        LargetsPostIntWithNeg obj = new LargetsPostIntWithNeg();
        System.out.println(obj.findMaxK(nums));
    }
}
