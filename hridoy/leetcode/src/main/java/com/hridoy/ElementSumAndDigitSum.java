package com.hridoy;

public class ElementSumAndDigitSum {
    public int differenceOfSum(int[] nums) {
        int digitSum = 0;
        int elementSum = 0;
        for (int i =0;i<nums.length;i++){
            elementSum+= nums[i];
            int reverse = 0;
            while(nums[i] != 0){
                int remainder = nums[i] % 10;
                reverse = reverse *10+remainder;
                nums[i] = nums[i]/10;
                digitSum += remainder;
            }
        }
    return  elementSum - digitSum;
    }

    public static void main(String[] args) {
        ElementSumAndDigitSum obj = new ElementSumAndDigitSum();
        int [] nums = {1,15,6,3};
        System.out.println(obj.differenceOfSum(nums));

    }
}
