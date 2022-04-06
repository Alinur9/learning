package leetcode.com.company;

public class CountIntegerWithEvenDigit {
    public int countEven(int num) {
        int result = 0;
        int dividend;
        int count = 0;
        for (int i = 1; i <= num; i++) {
            dividend = i;
            while (dividend > 0) {
                 result += dividend % 10;
                dividend /= 10;
            }

            if (result > 0 && result % 2 == 0  ) {
                count++;
            }

            result = 0;
        }
        return count;
    }

    public int digitSum(int input) {

        int i = 0;
        while (input > 0) {
            int res = input % 10;
            input /= 10;
            i = i + res;
        }

        return i;

    }


    public static void main(String[] args) {
        int num = 13;
        int res;
        int digitSum = 11;
        CountIntegerWithEvenDigit obj = new CountIntegerWithEvenDigit();
        int i = obj.digitSum(222);
        System.out.println(i);
        res = obj.countEven(num);
        System.out.println(res);
    }
}
