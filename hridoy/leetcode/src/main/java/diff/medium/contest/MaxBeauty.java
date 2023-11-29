package diff.medium.contest;

public class MaxBeauty {
    public int maximumBeauty(int[] nums, int k) {
        int max=0;

        for(int i=0;i< nums.length;i++){
            int count =0;
            for(int j=i+1;j < nums.length;j++){
                if(nums[i] == nums[j] || nums[j] -k <= nums[i] || nums[j] +k >= nums[i])
                    count ++;
            }
            if (count > max){
                max = count;
            }
        }
        return max+1;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,1,1};
        int k =2;
        MaxBeauty obj = new MaxBeauty();
        System.out.println(obj.maximumBeauty(nums,k));
    }
}
