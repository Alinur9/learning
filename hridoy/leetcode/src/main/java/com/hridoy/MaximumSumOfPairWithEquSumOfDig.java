package com.hridoy;

import java.util.HashMap;

public class MaximumSumOfPairWithEquSumOfDig {


    public int maximumSum(int[] nums) {

        HashMap<Integer,Integer> map = new HashMap<>();
        int max =-1;

        for (int value : nums){

            int key = sum(value);
             if (!map.containsKey(key)){
                 map.put(key,value);
             }
             else {
                 max = Math.max(max,map.get(key)+value);
                 map.put(key,Math.max(map.get(key),value));
             }
        }
       return max;
    }

    public  int sum (int sum){
        int sum1 = 0;
        int dig ;
        while (sum > 0){
            dig = sum %10;
            sum1 += dig;
            sum = sum /10;
        }
        return sum1;
    }
    public static void main(String[] args) {


        int[] nums = {18,43,36,13,7,72};

        MaximumSumOfPairWithEquSumOfDig obj = new MaximumSumOfPairWithEquSumOfDig();
        System.out.println(obj.maximumSum(nums));
    }
}
