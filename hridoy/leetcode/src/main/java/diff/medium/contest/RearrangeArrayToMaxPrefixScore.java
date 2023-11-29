package diff.medium.contest;

import java.util.Arrays;

public class RearrangeArrayToMaxPrefixScore {
    public int maxScore(int[] nums) {
        int numPositives = 0;
        int numNegatives = 0;
        for (int num : nums) {
            if (num > 0) {
                numPositives++;
            } else if (num < 0) {
                numNegatives++;
            }
        }
        Arrays.sort(nums);
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }
        int maxScore = numPositives;
        int score = numPositives;
        for (int i = 0; i < nums.length; i++) {
            if (prefixSum[i] > 0) {
                score++;
            } else if (prefixSum[i] == 0 && numNegatives > 0) {
                numNegatives--;
                score++;
            } else {
                break;
            }
            maxScore = Math.max(maxScore, score);
        }
        return maxScore;

}

    public static void main(String[] args) {
        int[] nums ={-687767,-860350,950296,52109,510127,545329,-291223,-966728,852403,828596,456730,-483632,-529386,356766,147293,572374,243605,931468,641668,494446};
        RearrangeArrayToMaxPrefixScore obj = new RearrangeArrayToMaxPrefixScore();
        System.out.println(obj.maxScore(nums));

    }
}
