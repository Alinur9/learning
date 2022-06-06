package leetcode.com.company;

import java.util.Arrays;

public class SumOf1DArray {
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        int[] sum = new int[n];
      sum [0] = nums[0];
      int sumRes =0;
      for (int i =1;i<n;i++){
          for (int j =0; j<= i;j++){
              sumRes += nums[j];
              sum[i] = sumRes;
          }
          sumRes =0;
        }
        return sum;


    }
    public static void main(String[] args) {
        int [] nums = {1,2,3,4};
        SumOf1DArray obj = new SumOf1DArray();
        System.out.println(Arrays.toString(obj.runningSum(nums)));
    }
}
