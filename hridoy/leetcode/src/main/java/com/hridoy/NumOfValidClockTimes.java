package com.hridoy;

import java.util.Arrays;

public class NumOfValidClockTimes {
    public int countTime(String time) {
        int h1 = 0;
        int m1 = 0;
        
        //24
        //60  
        
    String[] split = time.split(":");
    String hour = split[0];
    String minute = split[1];
    if (hour.charAt(0) == '?' && hour.charAt(1) == '?' && minute.charAt(0) == '?' && minute.charAt(1) == '?'){
        return 24*60;
    }
    if (hour.charAt(0) == '?' && hour.charAt(1) == '?' && minute.charAt(0) == '0' && minute.charAt(1) == '0'){
        return  24;
    }
    if (hour.charAt(0) == '0' && hour.charAt(1) == '0' && minute.charAt(0) == '?' && minute.charAt(1) == '?'){
        return 60;
    }
    if (hour.charAt(0) == '?' && hour.charAt(1) != '?'){
        if (Integer.parseInt(String.valueOf(hour.charAt(1))) >4){
            h1 = 2;
        }else {
            h1 =3;
        }
    }
    if (hour.charAt(0) != '?' && hour.charAt(1) == '?'){
        if (Integer.parseInt(String.valueOf(hour.charAt(0))) >2){
            h1 = 0;
        }
        if (Integer.parseInt(String.valueOf(hour.charAt(0))) == 0){
            h1 = 10;
        }else {
            h1 = 5;
        }
    }
    if (minute.charAt(0) != '?' && minute.charAt(1) == '?') {
        if (Integer.parseInt(String.valueOf(minute.charAt(0))) > 6) {
            m1 = 0;
        }
        if (Integer.parseInt(String.valueOf(minute.charAt(0))) < 6) {
            m1 = 10;
        } else {
            m1 = 1;
        }
    }
        if (minute.charAt(0) == '?' && minute.charAt(1) != '?'){
            if (Integer.parseInt(String.valueOf(minute.charAt(1))) <= 9){
                m1 = 6;
            }
            if (Integer.parseInt(String.valueOf(minute.charAt(1))) == 0){
                m1 =7;
            }
        }

        if (minute.charAt(0) != '?' || minute.charAt(1) != '?' && hour.charAt(0) == '?' && hour.charAt(1) == '?') {

            h1 = 24;
        }
        if (minute.charAt(0) == '?' || minute.charAt(1) == '?' && hour.charAt(0) != '?' || hour.charAt(1) != '?') {

            h1 = 60;
        }





        int res =0;

    if (m1 != 0 && h1 != 0){
        res = m1*h1;
    }
    if (m1 == 0 && h1 != 0){
        res = h1;
    }
    if (h1 == 0 && m1 != 0){
        res = m1;
    }

    
    
    
return res;

    }

    public static void main(String[] args) {
        String time = "07:?3";
        NumOfValidClockTimes obj = new NumOfValidClockTimes();
        System.out.println(obj.countTime(time));
    }
}
