package diff.medium.contest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CompleteSubArr {
    public int countCompleteSubarrays(int[] nums) {
        int count = 0;
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            HashSet<Integer> tempSet = new HashSet<>();
            for (int j = i; j < n; j++) {

                if (flag && tempSet.contains(nums[j])) {
                    count++;
                    continue;
                }
                tempSet.add(nums[j]);
                if (tempSet.size() == set.size()) {
                    String temp = tempSet.toString();
                    String s = set.toString();
                    if (temp.equals(s)) {
                        count++;
                        flag = true;
                    }

                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = {1632,1632,528,359,1671,1632,511,1087,424,16845};
        CompleteSubArr obj = new CompleteSubArr();
        System.out.println(obj.countCompleteSubarrays(nums));
    }
}
