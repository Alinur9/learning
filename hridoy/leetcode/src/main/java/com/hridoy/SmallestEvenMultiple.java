package com.hridoy;

public class SmallestEvenMultiple {
    public int smallestEvenMultiple(int n) {
    int small ;
        if (n % 2== 0){
            return n;
        }else {
            small = (n) *2;
        }
        return small;

    }

        public static void main(String[] args) {

        int n =99;
        SmallestEvenMultiple obj = new SmallestEvenMultiple();
            System.out.println(obj.smallestEvenMultiple(n));
    }
}
