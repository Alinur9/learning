package diff.medium.contest;

public class CountNumOfBadPairs {
    public long countBadPairs(int[] nums) {
        long badPairs = 0;
        long n = nums.length;

        for (int i =0; i < nums.length;i++){
            for (int j =i+1; j < nums.length;j++){
                if ( j - i == nums[j] - nums[i]){
                    badPairs++;
                }
            }
        }
        return n*(n-1)/2 - badPairs;
    }

    public static void main(String[] args) {

        int[] nums = {4,1,3,3};
        CountNumOfBadPairs obj = new CountNumOfBadPairs();
        System.out.println(obj.countBadPairs(nums));

    }
}
