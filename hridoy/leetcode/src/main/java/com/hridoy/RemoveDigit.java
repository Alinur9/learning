package com.hridoy;

import java.math.BigInteger;

public class RemoveDigit {
    public String removeDigit(String number, char digit) {

        String s = "";
        for (int i =0 ; i < number.length(); i++){
            if (number.charAt(i)  == digit){
                String s1 = number.substring(0,i) + number.substring(i+1);
               if (s1.compareTo(s) > 0){
                   s = s1;
               }
            }
        }

        return s;
    }
    public static void main(String[] args) {
        String number = "2998589353917872714814599237991174513476623756395992135212546127959342974628712329595771672911914471";
        char digit = '3';
        RemoveDigit obj = new RemoveDigit();
        System.out.println(obj.removeDigit(number,digit));

    }
}

