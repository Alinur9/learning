package diff.medium.contest;

import java.util.Arrays;

public class LongestSquareStreakInAnArr {
    public int longestSquareStreak(int[] nums) {
        int longestSquareStreak =0;
        Arrays.sort(nums);
        int l = nums.length;
        for (int k=0;k<l;k++) {
            if(longestSquareStreak < checkSub(nums,k,longestSquareStreak)){
                longestSquareStreak = checkSub(nums,k,longestSquareStreak);
        }
    l -= longestSquareStreak;
        }
        if (longestSquareStreak ==0){
            return -1;
        }
        return longestSquareStreak+1;
    }
    public int checkSub(int [] nums,int k,int size){
        int count =0;
        for (int i = k+1 + size; i < nums.length; i++) {
            if (nums[k] * nums[k] == nums[i ]) {
                count++;
                k=i;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,6,16,8,2};
        LongestSquareStreakInAnArr obj = new LongestSquareStreakInAnArr();
        System.out.println(obj.longestSquareStreak(nums));
    }
}
