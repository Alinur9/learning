package com.hridoy;

import java.util.Arrays;

public class SingleNumber {
    public int singleNumber(int[] nums) {
//        int ans =0;
//        int count ;
//       for (int i =0; i <nums.length;i++){
//           count =0;
//         for (int j =0 ; j < nums.length;j++){
//             if (nums[i] == nums[j]){
//                 count++;
//             }
//
//           }
//         if (count == 1){
//           ans = nums[i];
//         }
//        }
//        return ans;
//
        int ans =0;

        String s = (Arrays.toString(nums));
        for (char c : s.toCharArray()){

            int fidx = s.indexOf(c);
            int lidx =s.lastIndexOf(c);

            if (fidx == lidx){
                 ans = Integer.parseInt(String.valueOf(c));
                return ans;
            }

        }
        return ans;

    }

    public static void main(String[] args) {
        int [] nums =  {2,2,1};
        SingleNumber obj = new SingleNumber();
        System.out.println(obj.singleNumber(nums));

    }


}
