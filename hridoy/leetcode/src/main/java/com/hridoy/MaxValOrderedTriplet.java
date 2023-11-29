package com.hridoy;

public class MaxValOrderedTriplet {
    public long maximumTripletValue(int[] nums) {
        long sum;
        long max = Integer.MIN_VALUE;
        int n = nums.length;
        int tempVal=Integer.MIN_VALUE;
        int tempMax = Integer.MIN_VALUE;
        int temp3rd = Integer.MIN_VALUE;
        if (n ==3){
            long temp = (long) (nums[0] - nums[1]) * nums[2];
            if(temp > 0){
                return temp;
            }
            return 0;
        }


        for(int i=0;i<n;i++){
            if(tempMax > nums[i]){
                continue;
            }
            for(int j=i+1;j<n;j++){
                if(nums[i] - nums[j] < tempVal){
                    continue;
                }
                if(temp3rd != Integer.MIN_VALUE){
                    sum =  (long) (nums[i] - nums[j]) *temp3rd;
                    if(sum > max){
                        max = sum;
                    }
                    continue;
                }

                for(int k=j+1;k<n;k++){
                    sum = (long) (nums[i] - nums[j]) *(nums[k]) ;

                    if(sum > max){
                        max = sum;
                        tempVal = nums[i] - nums[j];
                        tempMax = nums[i];
                    }
                    if(nums[k] > temp3rd){
                        temp3rd = nums[k];
                    }
                }
            }
        }


return max < 1 ? 0 : max;
    }

    public static void main(String[] args) {
    int [] nums = {2,3,1};
    MaxValOrderedTriplet obj= new MaxValOrderedTriplet();
        System.out.println(obj.maximumTripletValue(nums));
    }
}
