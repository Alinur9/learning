package com.hridoy;

public class MinStrLength {
    public int minLength(String s) {
        StringBuilder sb = new StringBuilder(s);
        int index;

        while ((index = sb.indexOf("AB")) != -1 || (index = sb.indexOf("CD")) != -1) {
            sb.delete(index, index + 2);
        }
        return sb.length();
    }

    public static void main(String[] args) {
String s = "ABFCACDB";
MinStrLength obj = new MinStrLength();
        System.out.println(obj.minLength(s));
    }


}
