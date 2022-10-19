package com.hridoy;

public class MinimumTimeOfSecForFillAllCups {
    public int fillCups(int[] amount) {

        int second = 0;
        int coldCups = amount[0];
        int warmCups = amount[1];
        int hotCups = amount[2];

        while (coldCups != 0 || warmCups != 0 || hotCups != 0) {
            if (coldCups >= hotCups) {
                if (coldCups > 0 && warmCups > 0) {
                    coldCups--;
                    warmCups--;
                    second++;
                    continue;
                }
            }
            if (coldCups >= warmCups) {
                if (coldCups > 0 && hotCups > 0) {
                    coldCups--;
                    hotCups--;
                    second++;
                    continue;
                }
            }
           if (warmCups > 0 && hotCups > 0) {
                warmCups--;
                hotCups--;
                second++;
                continue;
            }
           if (warmCups == 0 && hotCups ==0 && coldCups > 0) {
                coldCups--;
                second++;
            }
           if (coldCups == 0 && hotCups ==0 && warmCups > 0) {
                warmCups--;
                second++;
            }
           if (warmCups == 0 && coldCups ==0 && hotCups > 0){
                hotCups--;
            second++;

        }
        }
        return second;

    }

    public static void main(String[] args) {

        int [] cupsOFWater = {0,4,4};

        MinimumTimeOfSecForFillAllCups obj = new MinimumTimeOfSecForFillAllCups();
        System.out.println(obj.fillCups(cupsOFWater));

    }
}
