package com.hridoy;

import java.time.LocalDate;
import java.util.HashMap;

public class CountDaySpentTogether {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        // "05-25";
        // split {"05", "25"};   split[0] = "05"

        String[] split = arriveAlice.split("-");
        int aAMonth = Integer.parseInt(split[0]);
        int aADay = Integer.parseInt(split[1]);

         split = leaveAlice.split("-");
        int aLMonth = Integer.parseInt(split[0]);
        int aLDay = Integer.parseInt(split[1]);

         split = arriveBob.split("-");
        int bAMonth = Integer.parseInt(split[0]);
        int bADay = Integer.parseInt(split[1]);


        split = leaveBob.split("-");
        int bLMonth = Integer.parseInt(split[0]);
        int bLDay = Integer.parseInt(split[1]);





        LocalDate d1 = LocalDate.of(2021,Integer.parseInt(arriveAlice.substring(0,2)),Integer.parseInt(arriveAlice.substring(3,5)));
        LocalDate d2 = LocalDate.of(2021,Integer.parseInt(leaveAlice.substring(0,2)),Integer.parseInt(leaveAlice.substring(3,5)));
        LocalDate d3 = LocalDate.of(2021,Integer.parseInt(arriveBob.substring(0,2)),Integer.parseInt(arriveBob.substring(3,5)));
        LocalDate d4 = LocalDate.of(2021,Integer.parseInt(leaveBob.substring(0,2)),Integer.parseInt(leaveBob.substring(3,5)));
        long aa = d1.toEpochDay(); //Alice Arrive
        long al = d2.toEpochDay(); //Alice Left
        long ba = d3.toEpochDay(); //Bob Arrive
        long bl = d4.toEpochDay(); //Bob Left
        if(al<ba || bl<aa) return 0; //No intersection of days
        return (int) ((Math.min(al,bl)-Math.max(aa,ba))+1); //Intersection of days


    }

    public static void main(String[] args) {

        String arriveAlice = "09-01";
                String leaveAlice = "10-19";
                String arriveBob = "06-19";
                String leaveBob = "10-20";

                CountDaySpentTogether obj = new CountDaySpentTogether();
        System.out.println(obj.countDaysTogether(arriveAlice,leaveAlice,arriveBob,leaveBob));

    }
}
