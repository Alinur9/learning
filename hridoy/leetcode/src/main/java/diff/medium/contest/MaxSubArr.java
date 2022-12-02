package diff.medium.contest;
import java.util.HashMap;


public class MaxSubArr {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        long mx = 0, sum = 0;
        for (int i = 0; i < nums.length; i++){
            sum +=nums[i];
            mp.put(nums[i], mp.getOrDefault(nums[i],0) + 1);

            if (i >= k - 1){
                if (mp.size() == k) mx = Math.max(mx, sum);
                sum -= nums[i - k + 1];
                mp.put(nums[i - k + 1], mp.get(nums[i - k + 1]) - 1);
                if (mp.get(nums[i - k + 1]) == 0) mp.remove(nums[i - k + 1]);
            }
        }
        return mx;
    }

        public static void main(String[] args) {
        int k =3;
        int[] nums = {1,5,4,2,9,9,9};
        MaxSubArr obj = new MaxSubArr();
            System.out.println(obj.maximumSubarraySum(nums,k));
    }
}
