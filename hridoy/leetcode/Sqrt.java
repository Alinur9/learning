package leetcode.com.company;

public class Sqrt {

    public int mySqrt(int x) {

        double temp = Math.sqrt(x);

        int res = (int)temp;

        return res;

    }

    public static void main(String[] args) {
        int x = 8;
        Sqrt obj = new Sqrt();
        System.out.println(obj.mySqrt(x));
    }
}
