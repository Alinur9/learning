package diff.medium.contest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Stream;

public class DivideArrayInSetsOfKconsNums {
    public boolean isPossibleDivide(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Arrays.sort(nums);
        if (nums.length % k != 0) return false;
        int track =0;
        int temp =0;
        int count = 1;
        int tempCount = 0;
        int div = 0;

        int value = nums[0];

        for (int i =0 ; i < nums.length-1;i++){

            if (track == 0 && nums[i] == nums[i+1]   || tempCount == k){

                if (tempCount == k){
                    temp = track;
                }
                track = i+1;
                if (tempCount == k) {
                    if (temp == 0) {
                        i = track - 1;
                    } else{
                        i = temp-1;
                }
                    tempCount =0;
                    if (temp == 0){
                        value = nums[track];
                    }else {
                        value = nums[temp];
                    }
                    track = 0;
                }
            }
            if (value+1 == nums[i+1] && map.get(i+1) == null){
                value = nums[i+1];
                map.put(i+1,0);
                count++;
                if (count == k){
                    tempCount = count;
                    count = 1;
                    div++;
                    if (div * (nums.length/2) == nums.length){
                        break;
                    }
                }
            }

        }
        if (tempCount== 1 ||  tempCount < k){
            return false;
        }
      return true;
    }


    public static void main(String[] args) {

        int [] nums = {10,9,8,1,2,3,2,3,4,4,5,6,10,11,12};
        int k = 3;
        DivideArrayInSetsOfKconsNums obj = new DivideArrayInSetsOfKconsNums();
        System.out.println(obj.isPossibleDivide(nums,k));

    }
}
