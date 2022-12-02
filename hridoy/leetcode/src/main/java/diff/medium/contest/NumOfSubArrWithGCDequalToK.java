package diff.medium.contest;

public class NumOfSubArrWithGCDequalToK {
    private int gcd(int a , int b){
        if(b == 0) return a;
        return gcd(b , a % b);
    }
    public int subarrayGCD(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int current_gcd = 0;
            for (int j = i; j < nums.length; j++) {
                current_gcd = gcd(current_gcd, nums[j]);
                if (current_gcd == k) count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {9,3,1,2,6,3};
        int k = 3;
        NumOfSubArrWithGCDequalToK obj = new NumOfSubArrWithGCDequalToK();
        System.out.println(obj.subarrayGCD(nums,k));
    }
}
