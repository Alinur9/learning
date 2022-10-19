package com.hridoy;

public class SecondLargestDigit {

    public int secondHighest(String s) {
        int a = -1;
        int b = -1;
        for (char chars : s.toCharArray()){
            if (Character.isDigit(chars)){
                int x = Character.getNumericValue(chars);
                if (x > a){
                    b = a;
                    a = x;
                } else if (x != a && x > b){
                    b = x;
                }
            }
        }
        return b;
    }
    public static void main(String[] args) {
        String s = "dfa15";
        SecondLargestDigit obj = new SecondLargestDigit();
        System.out.println(obj.secondHighest(s));
    }
}
