package com.hridoy;

public class FindMaxAchvNumber {
    public int theMaximumAchievableX(int num, int t) {


        return num+t*2;

    }
    public static void main(String[] args) {
        int num =4;
        int t =1;
        FindMaxAchvNumber obj = new FindMaxAchvNumber();
        System.out.println(obj.theMaximumAchievableX(num,t));
    }
}
