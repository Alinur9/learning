package com.hridoy;

public class FormSmallestNumFromTwoArr {
    public int minNumber(int[] nums1, int[] nums2) {
        int nums1Min = 10;
        int nums2Min = 10;
        int both =10;
        for (int i=0;i<nums1.length;i++){
            if (nums1Min > nums1[i]){
                nums1Min =nums1[i];
            }
            for(int j=0;j< nums2.length;j++){
                if (nums2Min > nums2[j]){
                    nums2Min =nums2[j];
                }
                if(nums1[i] == nums2[j]){
                    if(both > nums1[i]) {
                        both = nums1[i];
                    }

                }
            }
        }
        String s;
        if(nums1Min < nums2Min){
            s = String.valueOf(nums1Min) + String.valueOf(nums2Min);
        }else {
            s = String.valueOf(nums2Min) + String.valueOf(nums1Min);
        }
        if(both != 10){
            if (both < Integer.parseInt(s) )
            return both;
        }


 return Integer.parseInt(s);
    }

    public static void main(String[] args) {

        int[] nums1 = {3,5,2,6};
        int[] nums2 = {3,1,7};
        FormSmallestNumFromTwoArr obj = new FormSmallestNumFromTwoArr();
        System.out.println(obj.minNumber(nums1,nums2));


    }
}
