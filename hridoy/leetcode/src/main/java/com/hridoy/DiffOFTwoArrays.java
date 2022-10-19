package com.hridoy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DiffOFTwoArrays {

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2)  {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        HashSet<Integer> a1 = new HashSet<>();
        HashSet<Integer> a2 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++){
            a1.add(nums1[i] );
        }
        for (int i = 0; i < nums2.length;i++){
            a2.add(nums2[i]);
        }
        for (int i : a1){
            if (!a2.contains(i))
                temp.add(i);
        }
        res.add(temp);
        temp = new ArrayList<>();
        for (int i : a2){
            if (!a1.contains(i))
                temp.add(i);
        }
        res.add(temp);
        return res;
    }
    public static void main(String[] args) {
       int[] nums1 ={1,2,3,3};
       int[] nums2 = {1,1,2,2};
       DiffOFTwoArrays obj = new DiffOFTwoArrays();
       obj.findDifference(nums1,nums2);

    }
}
