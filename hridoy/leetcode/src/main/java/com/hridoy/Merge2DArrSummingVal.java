package com.hridoy;

import java.util.Arrays;
import java.util.HashMap;

public class Merge2DArrSummingVal {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        HashMap<Integer,Integer>  map = new HashMap<>();
        for (int i =0;i < nums1.length;i++){
                int key = nums1[i][0];
                int val = nums1[i][1];
                    map.put(key,val);
        }
        for (int i =0;i < nums2.length;i++){
            int key = nums2[i][0];
            int val = nums2[i][1];
            if ( map.containsKey(key)){
                map.put(key,map.get(key) + val);
            }else {
                map.put(key,val);
            }
        }
        int[][] ans = new int[map.size()][2];
        int  j =0;
        for (int i =0;i<= 1000;i++){
            if(map.containsKey(i)){
                ans[j][0] = i;
                ans[j][1] = map.get(i);
                j++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Merge2DArrSummingVal obj = new Merge2DArrSummingVal();
        int[][] nums1 = {{1,2},{500,3},{4,5}};
        int[][] nums2 = {{1,4},{3,2},{4,1}};
        System.out.println(Arrays.deepToString(obj.mergeArrays(nums1, nums2)));
    }
}
