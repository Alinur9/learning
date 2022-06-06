package leetcode.com.company;

import java.util.Arrays;

public class ClimbingStairs {

    public int climbStairs(int n) {
        if(n==0) return 0;
        int[] arr = new int[n+1];
        Arrays.fill(arr,1);

        arr[1] = 1;
        if(n==1) return 1;

        arr[2] = 2;
        if(n==2) return 2;

        arr[3] = 3;
        for(int i=4;i<=n;i++){
            arr[i] = arr[i-1]+arr[i-2];
        }
        return arr[n];
    }

    public static void main(String[] args) {
    int n = 7;
    ClimbingStairs obj = new ClimbingStairs();
        System.out.println(obj.climbStairs(n));
    }
}
