package diff.medium.contest;

import java.util.*;

public class MaxNumOfIntegers {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> set = new HashSet<>();
        for (int i : banned) {
            set.add(i);
        }
        int count = 0;
        for (int i = 1; i <= n && i <= maxSum; i++) {
            if (!set.contains(i)) {
                count++;
                maxSum -= i;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        int[] banned = {1,6,5};
        int n =5;
        int maxSum = 6;
        MaxNumOfIntegers obj = new MaxNumOfIntegers();
        System.out.println(obj.maxCount(banned,n,maxSum));
    }
}
