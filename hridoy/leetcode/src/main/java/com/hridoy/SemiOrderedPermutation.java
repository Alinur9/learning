package com.hridoy;

public class SemiOrderedPermutation {
    public int semiOrderedPermutation(int[] nums) {
    if(nums[0] ==1 & nums[nums.length-1] == nums.length){
        return 0;
    }
    int idx1 =0;
    int idxn =0;
    for(int i=0;i<nums.length;i++){
        if(nums[i] == 1){
            idx1 = i;
        }
        if(nums[i] == nums.length){
            idxn = i;
        }
    }

    if( idx1 > idxn){
        return idx1 + (nums.length-1 - idxn) -1;
    }
        return   idx1 + (nums.length-1 - idxn);
    }
    public static void main(String[] args) {
        int [] nums = {1,3,4,2,5};
        SemiOrderedPermutation obj = new SemiOrderedPermutation();
        System.out.println(obj.semiOrderedPermutation(nums));
    }
}
