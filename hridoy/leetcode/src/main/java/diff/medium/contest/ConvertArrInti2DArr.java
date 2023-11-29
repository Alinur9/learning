package diff.medium.contest;

import java.util.ArrayList;
import java.util.List;

public class ConvertArrInti2DArr {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> row = new ArrayList<>();

        int size = nums.length;
        while(size != 0 ) {
            for(int i=0;i< nums.length;i++){
                if(!row.contains(nums[i]) && nums[i] != 0){
                    row.add(nums[i]);
                    size--;
                    nums[i] =0;
                }
            }
            result.add(new ArrayList<>(row)); // create a new ArrayList and add it to the result
            row.clear(); // clear the original ArrayList
        }
        return result;
    }
    public static void main(String[] args) {
    int[] nums = {1,3,4,2};
    ConvertArrInti2DArr obj = new ConvertArrInti2DArr();
        System.out.println(obj.findMatrix(nums));

    }
}
