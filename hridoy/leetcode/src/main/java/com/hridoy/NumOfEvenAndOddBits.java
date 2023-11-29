package com.hridoy;

import java.util.Arrays;

public class NumOfEvenAndOddBits {

    public int[] evenOddBit(int n) {
        int even = 0, odd = 0;
        int i = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                if (i % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }
            }
            n --;
            i++;
        }
        return new int[] {even, odd};

    }

    public static void main(String[] args) {
        int num= 2;
        NumOfEvenAndOddBits obj = new NumOfEvenAndOddBits();
        System.out.println(Arrays.toString(obj.evenOddBit(num)));

    }
}
