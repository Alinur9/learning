package com.hridoy;

public class FindTheArrConcatenationVal {
    public long findTheArrayConcVal(int[] nums) {

        long ans =0;
        if(nums.length == 1){
            ans = nums[0];
            return ans;
        }
        int j = nums.length-1;
        for (int i =0;i<nums.length;i++){
            StringBuilder sb = new StringBuilder();
            if(nums[i] != 0) {
                sb.append(nums[i]);
                nums[i] = 0;
            }
            if(nums[j]!=0){
                sb.append(nums[j]);
                nums[j] =0;
            }
           if(sb.toString().isEmpty()){
               break;
           }
            ans += Long.parseLong(sb.toString());
            j--;
            if(i == nums.length/2){
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int []nums={5,14,13,8,12};
        FindTheArrConcatenationVal obj = new FindTheArrConcatenationVal();
        System.out.println(obj.findTheArrayConcVal(nums));
    }
}
