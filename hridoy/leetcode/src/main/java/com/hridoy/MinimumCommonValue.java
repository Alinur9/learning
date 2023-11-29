package com.hridoy;

public class MinimumCommonValue {

    public int getCommon(int[] nums1, int[] nums2) {

        int length = nums1.length;
        for(int i=0;i<length;i++){
            for(int j =0;j< nums2.length;j++){
                if(nums2[j]>nums1[i]){
                    break;
                }
                if(nums1[i]==nums2[j] ){
                    return nums1[i];
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 ={1,2,3,6};
        int[] nums2 ={2,3,4,5};
        MinimumCommonValue obj = new MinimumCommonValue();
        System.out.println(obj.getCommon(nums1,nums2));
    }

}
