package com.hridoy;

public class TotalDisTrav {

    public int distanceTraveled(int mainTank, int additionalTank) {
        int distance =0;
       while (mainTank >= 5){
           distance += 10*5;
           mainTank -= 5;
           if(additionalTank >0){
               mainTank++;
               additionalTank--;
           }
       }

        return distance + mainTank *10;
    }
    public static void main(String[] args) {
        TotalDisTrav obj = new TotalDisTrav();
        int mainTank = 5;
        int additionalTank = 10;
        System.out.println(obj.distanceTraveled(mainTank,additionalTank));

    }
}
