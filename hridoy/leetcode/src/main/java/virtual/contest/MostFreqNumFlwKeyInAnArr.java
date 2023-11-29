package virtual.contest;

import java.util.HashMap;

public class MostFreqNumFlwKeyInAnArr {
    public int mostFrequent(int[] nums, int key) {
        int most = 0;
        int ans =0;

        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i =0; i < nums.length-1;i++){
            if (nums[i] == key && map.containsKey(nums[i+1])) {
                map.put(nums[i + 1],map.get(nums[i+1])+1);
                continue;
            }
            if (nums[i] == key) {
                map.put(nums[i + 1], 1);
            }
        }
        for (int i =0; i < nums.length;i++){
            if (map.containsKey(nums[i]) && most < map.get(nums[i])){
                most = map.get(nums[i]);
               ans = nums[i];
            }
        }
        return ans;
    }


    public static void main(String[] args) {

        int[] nums = {1,1,2,1,2};
        int key =1;
        MostFreqNumFlwKeyInAnArr obj = new MostFreqNumFlwKeyInAnArr();
        System.out.println(obj.mostFrequent(nums,key));

    }
}
