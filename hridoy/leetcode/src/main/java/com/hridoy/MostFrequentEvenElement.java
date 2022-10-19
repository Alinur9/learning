package com.hridoy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MostFrequentEvenElement {
    public int mostFrequentEven(int[] nums) {
        int track ;
        int frequent1 = 0;
        int max = 0;
        Arrays.sort(nums);
        Map <Integer,Integer> map = new HashMap();

        for(int i =0; i < nums.length;i++){

            if (nums[i] %2 == 0 ){
                track = nums[i];
                if (!map.containsKey(track)){
                    frequent1 =0;
                }
                frequent1++;
                map.put(nums[i], frequent1);
                max = Math.max(max,frequent1);
            }
        }
        for (int i = 0 ; i < nums.length;i++){
            if (map.containsKey(nums[i]) && map.get(nums[i]) == max ){
                return nums[i];
            }
        }
        return -1;

    }



        public static void main(String[] args) {

        int [] nums = {10000};

        MostFrequentEvenElement obj =new MostFrequentEvenElement();
            System.out.println(obj.mostFrequentEven(nums));

    }
}
