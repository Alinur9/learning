package com.hridoy;

import java.util.ArrayList;
import java.util.List;

public class CountPairsLessThanTarget {
    public int countPairs(List<Integer> nums, int target) {
        int n = nums.size();
        int pairs =0;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if (nums.get(i) + nums.get(j) < target){
                    pairs++;
                }
            }
        }
    return pairs;
    }
    public static void main(String[] args) {
       List<Integer>  nums = new ArrayList<>();
       nums.add(-6);
       nums.add(2);
       nums.add(5);
       nums.add(-2);
       nums.add(-7);
       nums.add(-1);
       nums.add(3);
        int target = -2;
        CountPairsLessThanTarget obj = new CountPairsLessThanTarget();
        System.out.println(obj.countPairs(nums,target));
    }

}
