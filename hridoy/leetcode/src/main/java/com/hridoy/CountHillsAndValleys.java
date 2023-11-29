package com.hridoy;

public class CountHillsAndValleys {

    public int countHillValley(int[] nums) {
        int hills =0;
        int valleys =0;
        int flag =0;
        boolean hillsFlag = true;
        boolean valleysFlag = true ;

        for (int i =1;i< nums.length;i++){
            if(i == nums.length-1){
                if(hillsFlag){
                    hills++;
                }else{
                    valleys++;
                }
            }
            int next = nums[i+1];
            int previous = nums[i-1];
            if(nums[i] == nums[i+1]){
                next = travelNext(nums,i);
            }
            if(nums[i] == nums[i-1]){
                previous = travelPrevious(nums,i);
            }
            if(nums[i] > next && nums[i] > previous ){
                if (i == nums.length-1){
                    if(hillsFlag){
                        hills++;
                    }else {
                        valleys++;
                    }
                }
                if(flag < 1) {
                    valleys++;
                    flag++;
                }
              if(hillsFlag){
                  hills++;
                  hillsFlag = false;
                  valleysFlag = true;
              }

            }
            if(nums[i] == nums[i+1]){
                next = travelNext(nums,i);
            }
            if(nums[i] == nums[i-1]){
                previous = travelPrevious(nums,i);
            }
            if(nums[i] < next && nums[i] < previous ){
                if(flag < 1) {
                    hills++;
                    flag++;
                }
              if(valleysFlag){
                  valleys++;
                  valleysFlag = false;
                  hillsFlag = true;
              }
            }

        }
        return valleys + hills - valleys;

    }

    public int travelNext(int[] nums,int idx){
        int value = nums[idx];
        int i = idx;
        while(i < nums.length && nums[i] == value){
            i++;
        }

        return nums[i];
    }
    public int travelPrevious(int[] nums,int idx){
        int value = nums[idx];
        int i = idx;
        while(i >0 && nums[i] == value){
            i--;
        }
        return nums[i];
    }

    public static void main(String[] args) {

        int []nums = {2,4,1,1,6,5};
        CountHillsAndValleys obj = new CountHillsAndValleys();
        System.out.println(obj.countHillValley(nums));

    }
        }
