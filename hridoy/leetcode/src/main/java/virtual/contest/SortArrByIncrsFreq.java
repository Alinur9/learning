package virtual.contest;

import java.util.Arrays;

public class SortArrByIncrsFreq {
    public int[] frequencySort(int[] nums) {

        int countOcc =0;
        int freq =0;

        int[] sortedArr = new int[nums.length];


        for (int i =0; i < nums.length;i++){
            for (int j =i+1; j < nums.length;j++){
                if (nums[i] == nums[j]){
                    countOcc++;
                }
                if (countOcc ==0){
                    freq = nums[i];
                }
            }

        }
        return nums;

    }

    public static void main(String[] args) {
        int[] nums = {-1,1,-6,4,5,-6,1,4,1};

        SortArrByIncrsFreq obj = new SortArrByIncrsFreq();
        System.out.println(Arrays.toString(obj.frequencySort(nums)));

    }
}
