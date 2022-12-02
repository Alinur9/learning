package diff.medium.contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i =0; i < nums.length;i++){
            for (int j = i+1 ; j < nums.length;j++ ) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k ] == 0) {
                        list.add(nums[i]);
                        list.add(nums[j] );
                        list.add(nums[k] );
                        if (!ans.contains(list)) {
                            ans.add(list);
                        }
                        list = new ArrayList<>();
                    }
                }
            }
        }
return ans;
    }

    public static void main(String[] args) {

        int [] nums = {-1,0,1,2,-1,-4};
        ThreeSum obj = new ThreeSum();
        System.out.println(obj.threeSum(nums));

    }
}
