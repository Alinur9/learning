package com.hridoy;

public class MaxOddBinaryNum {
    public String maximumOddBinaryNumber(String s) {
        int numOnes=0;
        StringBuilder ones = new StringBuilder();
        StringBuilder zero = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '1') {
                numOnes++;
            }
        }
        for (int i =0;i<numOnes-1;i++) {
            ones.append('1');
        }
        for (int i = 0; i < s.length() - numOnes; i++) {
            zero.append('0');
        }

        return ones + zero.toString() + "1";
    }
    public static void main(String[] args) {

        String s = "110";
        MaxOddBinaryNum obj = new MaxOddBinaryNum();
        System.out.println(obj.maximumOddBinaryNumber(s));

    }
}


