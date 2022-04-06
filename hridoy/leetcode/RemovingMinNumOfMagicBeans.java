package leetcode.com.company;

import java.util.Arrays;

public class RemovingMinNumOfMagicBeans {
    public long minimumRemoval(int[] beans) {
        long mx = 0, sum = 0;
        Arrays.sort(beans);
        for (int i = 0, n = beans.length; i < n; i++) {
            sum += beans[i];
            mx = Math.max(mx, (long)beans[i] * (n - i));
        }
        return sum - mx;
    }

    public static void main(String[] args) {
        int[] beans = {2,10,3,2};
        long res;
        RemovingMinNumOfMagicBeans obj = new RemovingMinNumOfMagicBeans();
        res= obj.minimumRemoval(beans);
        System.out.println(res);
    }
}
