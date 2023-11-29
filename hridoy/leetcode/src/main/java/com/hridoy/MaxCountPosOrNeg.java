package com.hridoy;

public class MaxCountPosOrNeg {

    public int maximumCount(int[] nums) {
        int pos =0;
        int neg =0;
        for(int i =0; i< nums.length;i++){
            if (nums[i] ==0){
                continue;
            }
            if(nums[i] < 0){
                neg++;
            }else {
                pos++;
            }
        }
        if(pos>neg){
            return pos;
        }
        return neg;
    }

    public static void main(String[] args) {
        int [] nums = {-3,-2,-1,0,0,1,2};
        MaxCountPosOrNeg obj = new MaxCountPosOrNeg();
        System.out.println(obj.maximumCount(nums));

    }
}
