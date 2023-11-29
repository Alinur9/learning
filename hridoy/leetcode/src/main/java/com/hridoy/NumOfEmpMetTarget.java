package com.hridoy;

public class NumOfEmpMetTarget {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
            int count =0;
            for(int i=0;i <hours.length;i++){
                if(hours[i] >= target){
                    count++;
                }
            }
            return count;
    }
    public static void main(String[] args) {
        int[] hours = {0,1,2,3,4};
        int target = 2;
        NumOfEmpMetTarget obj = new NumOfEmpMetTarget();
        System.out.println(obj.numberOfEmployeesWhoMetTarget(hours,target));
    }
}
