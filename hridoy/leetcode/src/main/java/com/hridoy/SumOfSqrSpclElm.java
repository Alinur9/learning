package com.hridoy;

public class SumOfSqrSpclElm {
    public int sumOfSquares(int[] nums) {
        int sum =0;
        int n = nums.length;
        for(int i =0;i < n+1;i++){
            if(n % (i+1)== 0){
                sum += nums[i] * nums[i];
            }
        }
return sum;
    }
    public static void main(String[] args) {
        int[] nums = {2,7,1,19,18,3};
        SumOfSqrSpclElm obj = new SumOfSqrSpclElm();
        System.out.println(obj.sumOfSquares(nums));
    }
}
