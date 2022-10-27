package com.hridoy;

import java.util.HashMap;

public class TheEmpThatWorkedOnTheLongestTask {
    public int hardestWorker(int n, int[][] logs) {

        HashMap<Integer,Integer> id = new HashMap<>();
        id.put(logs[0][0],logs[0][1]);
        for (int i =1 ; i < logs.length;i++){
                    int sum = logs[i][1] - logs[i-1][1];
                    if (id.containsKey(logs[i][0]) && sum > id.get(logs[i][0]) ){
                            id.put(logs[i][0],sum);
                    }
                    if (!id.containsKey(logs[i][0])) {
                        id.put(logs[i][0], sum);
                    }
                }

        int max =0;
        int min = 500;
        for (int i=0 ; i <= 500;i++){
            if (id.get(i) != null && id.get(i) > max){
                max = id.get(i);
                    min = i;
                    continue;
            }
            if (id.get(i) != null && id.get(i) == max){
               if ( min > i){
                   min = i;
               }
            }

        }
        return min;

    }

    public static void main(String[] args) {
        int n = 26;
        int[][] logs = {
                {110,5},{360,7},{48,8},{286,10},{167,12},{110,13},{221,18}};
        TheEmpThatWorkedOnTheLongestTask obj = new TheEmpThatWorkedOnTheLongestTask();
        System.out.println(obj.hardestWorker(n,logs));
    }
}
