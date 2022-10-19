package com.hridoy;


public class CalculatingDigitSumOfString {
    public String digitSum(String s, int k) {


        StringBuilder sb = new StringBuilder(s);
        while (sb.length() > k) {
            StringBuilder next = new StringBuilder();
            int sum = 0;
            for (int i = 0; i < sb.length(); i++) {
                sum += sb.charAt(i) - '0';
                if ((i + 1) % k == 0 || i == sb.length() - 1) {
                    next.append(sum);
                    sum = 0;
                }
            }
            sb = next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "11111222223";
        int k = 3;

        CalculatingDigitSumOfString obj = new CalculatingDigitSumOfString();
        System.out.println(obj.digitSum(s,k));

    }
}
