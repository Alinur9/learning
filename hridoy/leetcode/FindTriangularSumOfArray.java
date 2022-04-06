package leetcode.com.company;

import java.util.Arrays;

public class FindTriangularSumOfArray {
    public int triangularSum(int [] nums){
        int n = nums.length-1;
        if (n == 0 ){
            return nums[0];
        }
        int[] newNums = new int[n];
        for (int i = 0; i < n ; i++){
            newNums[i]= (nums[i] + nums[i+1]) % 10;
        }
       // triangularSum(newNums);

        return   triangularSum(newNums);


    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8};
        FindTriangularSumOfArray obj = new FindTriangularSumOfArray();
        int res = obj.triangularSum(nums);
        System.out.println(res);
    }
}
