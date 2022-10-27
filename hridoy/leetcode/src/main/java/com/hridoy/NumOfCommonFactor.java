package com.hridoy;

public class NumOfCommonFactor {
    public int commonFactors(int a, int b) {
        int x = 0;
        int big = 0;
        if (a > b){
            big = a;
        }else {
            big = b;
        }

        for (int i =1 ; i <= big;i++){
            if (a % i == 0 && b % i ==0){
                x++;
            }
        }
        return x;

    }

    public static void main(String[] args) {
        int a = 2;
        int b = 2;
NumOfCommonFactor obj = new NumOfCommonFactor();
        System.out.println(obj.commonFactors(a,b));
    }
}
