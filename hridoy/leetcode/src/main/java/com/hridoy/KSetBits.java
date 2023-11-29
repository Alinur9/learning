package com.hridoy;

import java.util.ArrayList;
import java.util.List;

public class KSetBits {

    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {

        int sum =0;
        for(int i=0;i<nums.size();i++){
            int count =0;

            String binaryString = Integer.toBinaryString(i);
            for(int j=0;j< binaryString.length();j++){
                if(binaryString.charAt(j) == '1'){
                    count++;
                }
            }
            if (count == k){
                sum += nums.get(i);
            }
        }
return sum;
    }

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        int k =1;
        nums.add(5);
        nums.add(10);
        nums.add(1);
        nums.add(5);
        nums.add(2);
        KSetBits obj = new KSetBits();
        System.out.println(obj.sumIndicesWithKSetBits(nums,k));
    }
}
