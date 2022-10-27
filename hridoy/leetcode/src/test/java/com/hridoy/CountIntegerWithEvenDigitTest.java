package com.hridoy;

import org.junit.jupiter.api.Test;

class CountIntegerWithEvenDigitTest {

    @Test
    void test1() {
        int num = 13;
        int res;
        int digitSum = 11;
        CountIntegerWithEvenDigit obj = new CountIntegerWithEvenDigit();
        int i = obj.digitSum(222);
        System.out.println(i);
        res = obj.countEven(num);
        System.out.println(res);
    }


    @Test
    void test2() {
        int num = 13;
        int res;
        int digitSum = 11;
        CountIntegerWithEvenDigit obj = new CountIntegerWithEvenDigit();
        int i = obj.digitSum(456);
        System.out.println(i);
        res = obj.countEven(num);
        System.out.println(res);
    }


}