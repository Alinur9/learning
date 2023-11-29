package com.hridoy;

public class CategorizeAccordingCretria {
    public String categorizeBox(int length, int width, int height, int mass) {
        boolean bulky = false;
        boolean heavy = false;
        long volume = (long) length *width*height;
        if (volume >= 1000000000 || length >= 10000 ||
                width >= 10000 || height >= 10000){
            bulky = true;
        }
        if (mass >= 100){
            heavy = true;
        }
        if (heavy && bulky){
            return "Both";
        }
        if (bulky){
            return "Bulky";
        }
        if(heavy){
            return "Heavy";
        }
        return "Neither";

    }


    public static void main(String[] args) {

        int length = 1000;
        int width = 35;
        int height = 700;
        int mass = 300;

        CategorizeAccordingCretria obj = new CategorizeAccordingCretria();
        System.out.println(obj.categorizeBox(length,width,height,mass));

    }
}
