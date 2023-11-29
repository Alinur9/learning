package diff.medium.contest;

import java.util.Arrays;

public class MaximalScore {
    public long maxKelements(int[] nums, int k) {
        long score = 0;
        int length = nums.length-1;
        Arrays.sort(nums);
        int i = length;
        while (i != -1){
            if (k != 0 ){
                score += nums[i];
                double mod = (double) nums[i]/3;
                int ceil = (int)Math.ceil(mod);
                nums[i] = ceil;
                k--;
                if(k==0){
                    break;
                }
                if(i != 0 ){
                    while (nums[i] > nums[i-1]){
                        mod =(double) nums[i]/3;
                        ceil = (int)Math.ceil(mod);
                        score+= nums[i];
                        nums[i] = ceil;
                        k--;
                        if (k == 0){
                            break;
                        }
                    }
                }
                i--;
            }

        }
        return score;
    }

    public static void main(String[] args) {
        int[]nums = {756902131,995414896,95906472,149914376,387433380,848985151};
        int k=6;
        MaximalScore obj = new MaximalScore();
        System.out.println(obj.maxKelements(nums,k));

    }
}
