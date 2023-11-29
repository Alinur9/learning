package com.hridoy;

import java.util.HashMap;

public class FoundChampion1 {
    public int findChampion(int[][] grid) {

        int[] teams = new int[grid.length];

        for (int i=0; i< grid.length;i++){
            int count =0;
            for (int j=0;j< grid[0].length;j++){
                if(grid[i][j] ==1 ){
                    count++;
                }
            }
            teams[i] = count;
        }
      int team=0;
        int point = teams[0];
        for(int i=1;i< teams.length;i++){
            if(teams[i] > point){
                point = teams[i];
                team =i;
            }

        }
        return team;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,0,1},{1,0,1},{0,0,0}};
        FoundChampion1 obj = new FoundChampion1();
        System.out.println(obj.findChampion(grid));
    }
}
