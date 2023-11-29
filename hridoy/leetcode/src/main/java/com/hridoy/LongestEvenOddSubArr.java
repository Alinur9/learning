package com.hridoy;

public class LongestEvenOddSubArr {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int length =0;
        int i =0;
        boolean find=false;
        boolean find2=false;
        if(nums.length ==1){
            if(nums[0] %2 == 0 && nums[0] <= threshold){
                return 1;
            }else {
                return 0;
            }
        }
        while (!find ){
            if (i == nums.length){
                if(find2 ){
                    return 1;
                }
                break;
            }

            if(nums[i] % 2 == 0 && nums[i] <= threshold){
                    find2 = true;
                if( i +1 < nums.length && nums[i] %2 == 0 && nums[i+1] %2 ==0 ){
                    i++;
                    continue;
                }if(nums[i] %2 != 0) {
                    continue;
                }
                length++;
                find = true;
                for(int j=i+1;j < nums.length;j++){
                    if(nums[j] %2 != nums[j-1] %2 && nums[j] <= threshold){
                        length++;
                    }else {
                        break;
                    }
                }

            }
            i++;
        }
return length;
    }
    public static void main(String[] args) {

        int[] nums = {2,8};
        int threshold= 4;
        LongestEvenOddSubArr obj = new LongestEvenOddSubArr();
        System.out.println(obj.longestAlternatingSubarray(nums,threshold));

    }
}
