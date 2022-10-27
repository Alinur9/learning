package virtual.contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindTargetIndicesAfterSortingArray {
        public List<Integer> targetIndices(int[] nums, int target) {

            List<Integer> list = new ArrayList<>();
            Arrays.sort(nums);
            for (int i =0; i < nums.length;i++){
                if (nums[i] == target){
                    list.add(i);
                }
            }
            return list;
        }



        public static void main(String[] args) {

        int[] nums = {1,2,5,2,3};
        int target = 2;

        FindTargetIndicesAfterSortingArray obj = new FindTargetIndicesAfterSortingArray();
            System.out.println(obj.targetIndices(nums,target));


    }
}
