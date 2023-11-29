package diff.medium.contest;

import java.util.HashMap;

public class MaxDivisiblityScore {
    public int maxDivScore(int[] nums, int[] divisors) {

        int[] scores = new int[divisors.length];
        int maxScore = 0;
        int maxDivisor = Integer.MAX_VALUE;
        for (int i = 0; i < divisors.length; i++) {
            int score = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] % divisors[i] == 0) {
                    score++;
                }
            }
            scores[i] = score;
            if (score > maxScore || (score == maxScore && divisors[i] < maxDivisor)) {
                maxScore = score;
                maxDivisor = divisors[i];
            }
        }
        return maxDivisor;
    }
    public static void main(String[] args) {
        int[] nums = {4,7,9,3,9};
        int[] divisors = {5,2,3};
        MaxDivisiblityScore obj = new MaxDivisiblityScore();
        System.out.println(obj.maxDivScore(nums,divisors));
    }
}
