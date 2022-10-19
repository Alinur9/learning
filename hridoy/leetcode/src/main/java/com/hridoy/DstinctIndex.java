package com.hridoy;

import java.util.ArrayList;
import java.util.List;

public class DstinctIndex {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> keyIndList = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == key){
                keyIndList.add(i);
            }
        }
        List<Integer> result = new ArrayList<>();
        if(keyIndList.size() == 0){ return result; }

        // check for each index in list
        for(int i = 0; i < nums.length; i++){
            for(int ind : keyIndList){
                if(Math.abs(i - ind) <= k){
                    result.add(i);
                    break;
                }
            }
        }

        return result;
    }

        public static void main(String[] args) {
        int [] nums ={2,2,2,2,2};
        int key = 2;
        int k = 2;
        DstinctIndex obj = new DstinctIndex();
        obj.findKDistantIndices(nums,key,k);
    }
}
