package diff.medium.contest;

import com.hridoy.MountainTriplet;

public class MountainTripletTwo {
    public int minimumSum(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return -1;
        }

        int minSum = Integer.MAX_VALUE;

        for (int j = 1; j < n - 1; j++) {
            int leftMin = Integer.MAX_VALUE;
            int rightMin = Integer.MAX_VALUE;

            for (int i = 0; i < j; i++) {
                if (nums[i] < nums[j]) {
                    leftMin = Math.min(leftMin, nums[i]);
                }
            }

            for (int k = j + 1; k < n; k++) {
                if (nums[k] < nums[j]) {
                    rightMin = Math.min(rightMin, nums[k]);
                }
            }

            if (leftMin != Integer.MAX_VALUE && rightMin != Integer.MAX_VALUE) {
                int tempSum = leftMin + nums[j] + rightMin;
                minSum = Math.min(minSum, tempSum);
            }
        }

        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }

    public static void main(String[] args) {
        int [] nums = {1,3,1,2};
        MountainTripletTwo obj = new MountainTripletTwo();
        System.out.println(obj.minimumSum(nums));
    }
}
