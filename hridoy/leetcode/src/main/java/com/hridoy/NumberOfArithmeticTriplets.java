package com.hridoy;

public class NumberOfArithmeticTriplets {
    public int arithmeticTriplets(int[] nums, int diff) {
    int triplets =0;
    int ans =0;
    int j1 =0;
        for(int i =0 ; i< nums.length;i++){
            for (int j = i+1; j < nums.length;j++){
                if (nums[j]- nums[i] == diff){
                    j1 = j;
                    break;
                    }
            }
            if (j1 != 0){
            for (int k = j1+1; k < nums.length; k++){
                if (nums[k] - nums[j1] == diff) {
                    ans++;
                    if (k == nums.length-1){
                        return ans;
                    }
                    j1=0;
                    break;
                }

                }
            }


        }
    return ans;

    }

    public static void main(String[] args) {
    int [] nums = {2,10,14,19,20,24,30,34,45,48};
    int diff = 10;
        NumberOfArithmeticTriplets obj = new NumberOfArithmeticTriplets();
        System.out.println(obj.arithmeticTriplets(nums,diff));
    }
}
