package leetcode.com.company;

public class MinMaxGame {

    public int minMaxGame(int[] nums) {
        int n = nums.length;
        if (nums.length == 1 ){
            return nums[0];
        }
        int min ;
        int max ;
        int odd = 1;
        int count =0;

        while (n != 1){
            for (int i = 0; i < n/2;i++){

                if (i +1 < nums.length && odd % 2 != 0){
                    min = Math.min(nums[2*i],nums[2*i+1]);
                    nums[count] = min;
                    count++;
                }
                if (i +1 < nums.length && odd % 2 == 0){
                    max = Math.max(nums[2*i],nums[2*i+1]);
                    nums[count] = max;
                    count++;
                }
                odd++;
            }
            n = count;
            count =0;

            
        }
        return nums[0];
    }
    public static void main(String[] args) {
        int[]nums = {1,3,5,2,4,8,2,2};
        MinMaxGame obj = new MinMaxGame();
        System.out.println(obj.minMaxGame(nums));
    }
}
