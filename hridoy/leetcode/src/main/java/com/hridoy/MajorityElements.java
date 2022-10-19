package com.hridoy;

public class MajorityElements {
    public int majorityElement(int[] nums) {
        int count = 0;
        int majority = (nums.length/2);
        for (int i=0; i < nums.length;i++){
            for (int j =0;j < nums.length;j++){
                if (nums[i] == nums[j]){
                    count++;
                }
            }

            if (count > majority ){
                return nums[i];
            }
            count =0;

        }
        return 0;
    }
    public static void main(String[] args) {
        int[] nums = {8,8,7,7,7};
        MajorityElements obj = new MajorityElements();
        System.out.println(obj.majorityElement(nums));

    }
}
