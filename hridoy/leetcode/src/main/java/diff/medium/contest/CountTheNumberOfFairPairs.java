package diff.medium.contest;

import java.util.Arrays;

public class CountTheNumberOfFairPairs {
    public long countFairPairs(int[] nums, int lower, int upper) {
        long count = 0;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int target1 = upper - nums[i];
            int target2 = lower - nums[i] - 1;

            int j = binarySearch(nums, i + 1, nums.length - 1, target1);
            int k = binarySearch(nums, i + 1, nums.length - 1, target2);
            count += j - k;
        }
        return count;
    }

    public int binarySearch(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }




        public static void main(String[] args) {
        int[] nums = {0,1,7,4,4,5};
        int lower = 3;
        int upper = 6;
        CountTheNumberOfFairPairs obj = new CountTheNumberOfFairPairs();
        System.out.println(obj.countFairPairs(nums,lower,upper));

    }
}
