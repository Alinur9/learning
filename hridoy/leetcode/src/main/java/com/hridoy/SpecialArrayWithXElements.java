package com.hridoy;

public class SpecialArrayWithXElements {

    public int specialArray(int[] nums) {
        int leng = nums.length;
        int count = 0;
        int checkNum =0;
        for (int i =0;i<leng;i++){
            if (nums[i] == 0 ){
                checkNum++;
            }
        }
        checkNum = leng-checkNum;
        for (int j =0 ; j < leng;j++){
            for (int k =0;k < leng;k++){
              if (nums[j] <= nums[k]){
                  count++;
              }
            }
            if(count == checkNum){
                return checkNum;
            }
            count =0;
        }
        return -1;
    }
    public static void main(String[] args) {

        int[] nums = {0,5,6,0,4};
        SpecialArrayWithXElements obj = new SpecialArrayWithXElements();
        System.out.println(obj.specialArray(nums));

    }
}
