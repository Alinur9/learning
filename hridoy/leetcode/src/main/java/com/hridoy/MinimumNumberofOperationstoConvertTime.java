package com.hridoy;

public class MinimumNumberofOperationstoConvertTime {
    public int convertTime(String current, String correct) {
        int count = 0;

        String[] current_time = current.split(":");
        int current_hour = Integer.parseInt(current_time[0]);
        current_hour *= 60;
        int current_min = Integer.parseInt(current_time[1]);
        current_hour += current_min;

        String[] correct_time = correct.split(":");
        int correct_hour = Integer.parseInt(correct_time[0]);
        correct_hour *= 60;
        int correct_min = Integer.parseInt(correct_time[1]);
        correct_hour += correct_min;

        while (correct_hour - current_hour >= 60){
            count++;
            current_hour += 60;
        }
        while (correct_hour - current_hour >= 15){
            count++;
            current_hour += 15;
        }
        while (correct_hour - current_hour >= 5){
            count++;
            current_hour += 5;
        }
        while (correct_hour - current_hour >= 1){
            count++;
            current_hour += 1;
        }
        return count;

    }

    public static void main(String[] args) {
        String current = "02:30";
        String correct = "04:35";
        MinimumNumberofOperationstoConvertTime obj = new MinimumNumberofOperationstoConvertTime();
        int res = obj.convertTime(current,correct);
        System.out.println(res);
    }
}
