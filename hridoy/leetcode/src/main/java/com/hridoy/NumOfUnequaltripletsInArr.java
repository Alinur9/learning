package com.hridoy;

public class NumOfUnequaltripletsInArr {
    int track = -1;
    int k = 0;
    public int unequalTriplets(int[] nums) {

        int count = 0;
        int n = nums.length;
        for ( int i = 0 ; i < n ;i++ ){
            track = -1;
            for (int j = i+1; j < n;j++){
                track = -1;
                 k = j +1;
                if (nums[i] != nums[j] ) {
                    while (k < n && k != track ) {
                        if (checkTriplet(nums[i], nums[j], k, nums)) {
                            count++;
                        }
                    }
                }
               }
            }
return count;
    }
    boolean checkTriplet (int value1,int value2 ,int idx,int[ ]nums){
        for (int  i = idx ; i < nums.length ;i++ ){
            if (value1  != nums[i] && value2 != nums[i]){
                track = i;
                k = i+1;
                return true;
            }
            k++;
        }
        return false;
    }

    public static void main(String[] args) {
        int [] nums ={1,2,1};

        NumOfUnequaltripletsInArr obj = new NumOfUnequaltripletsInArr();
        System.out.println(obj.unequalTriplets(nums));

    }
}
