package virtual.contest;

public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n <= 2)
            return n;
        int one = 1;
        int two = 2;
        for (int i = 3; i <= n; i++) {
            int temp = one;
            one = two;
            two += temp;
        }
        return two;
    }

    public static void main(String[] args) {
        int n =7;
        ClimbingStairs obj = new ClimbingStairs();
        System.out.println(obj.climbStairs(n));

    }
}
