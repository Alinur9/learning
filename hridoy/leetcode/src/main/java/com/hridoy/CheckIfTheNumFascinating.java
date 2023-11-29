package com.hridoy;

import java.math.BigInteger;
import java.util.Arrays;

public class CheckIfTheNumFascinating {

    public boolean isFascinating(int n) {

        String p1 = String.valueOf(n);
        String p2 = String.valueOf(2*n);
        String p3 = String.valueOf(3*n);

        StringBuilder sb = new StringBuilder();
        sb.append(p1).append(p2).append(p3);

        long number = Long.parseLong(sb.toString());
        String numberString = String.valueOf(number);
        int[] array = new int[numberString.length()];

        for (int i = 0; i < numberString.length(); i++) {
            array[i] = Character.getNumericValue(numberString.charAt(i));
        }

        Arrays.sort(array);
        int count =1;
        for(int i=0;i < array.length;i++){
            if(array[i] != count){
                return false;
            }
            if (count == 10){
                break;
            }
            count++;

        }



        return true;

    }

    public static void main(String[] args) {
        CheckIfTheNumFascinating obj = new CheckIfTheNumFascinating();
        int n = 334;
        System.out.println(obj.isFascinating(n));
    }
}
