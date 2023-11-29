package com.hridoy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SeparateDigInAnArr {
    public int[] separateDigits(int[] nums) {
       List<Character> arr = new ArrayList<>();

        for(int i=0;i<nums.length;i++){

            int numsSize = String.valueOf(nums[i]).length();
            String s = String.valueOf(nums[i]);
            int j =0;
            while(numsSize != 0){
                arr.add(s.charAt(j));
                j++;
                numsSize--;
            }
        }
        int[] ans = new int[arr.size()];
        for (int i=0;i<arr.size();i++){
            ans[i] = Integer.parseInt(String.valueOf(arr.get(i)));
        }
        return ans;

    }



        public static void main(String[] args) {

        int [] nums = {7,1,3,9};
        SeparateDigInAnArr obj = new SeparateDigInAnArr();
            System.out.println(Arrays.toString(obj.separateDigits(nums)));

    }
}
