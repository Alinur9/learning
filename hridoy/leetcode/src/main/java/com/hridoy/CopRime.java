package com.hridoy;

public class CopRime {



    public static int countBeautifulPairs(int[] nums) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int firstDigit = Integer.parseInt(Integer.toString(nums[i]).substring(0, 1));
                int lastDigit = nums[j] % 10;
                if (isCoprime(firstDigit, lastDigit)) {
                    count++;
                }
            }
        }

        return count;
    }

        public static int gcd(int a, int b) {
            while (b != 0) {
                int temp = b;
                b = a % b;
                a = temp;
            }
            return a;
        }

        public static boolean isCoprime(int a, int b) {
            return gcd(a, b) == 1;
        }

    public static void main(String[] args) {

        int [] nums = {11,21,12};
        CopRime obj = new CopRime();
        System.out.println(countBeautifulPairs(nums));
    }
}
