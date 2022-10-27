package virtual.contest;

import java.util.Arrays;

public class RmvOneElemn {
    public boolean canBeIncreasing(int[] nums) {
        int error = 0;
        for ( int i = 1; i < nums.length; i++ )
            if ( nums[i] <= nums[i - 1] ) {
                if ( error > 0 ) return false;
                error++;
                if ( i > 1 && nums[i] <= nums[i - 2] ) nums[i] = nums[i - 1];
            }
        return true;

    }

    public static void main(String[] args) {

        int [] nums = {2,3,1,2};
        RmvOneElemn obj = new RmvOneElemn();
        System.out.println(obj.canBeIncreasing(nums));

    }
}
