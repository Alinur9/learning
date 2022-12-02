package com.hridoy;

import java.util.Arrays;

public class ConvertTemp {
    public double[] convertTemperature(double celsius) {
        double [] arr = new double[2];

         arr [0] = celsius + 273.15;
        arr [1] = celsius * 1.80 + 32.00;

         return arr;
    }

    public static void main(String[] args) {

        float celsius = 36.50F;
        ConvertTemp obj = new ConvertTemp();
        System.out.println(Arrays.toString(obj.convertTemperature(celsius)));

    }
}
