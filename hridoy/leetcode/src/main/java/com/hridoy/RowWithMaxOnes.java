package com.hridoy;

import java.util.Arrays;
import java.util.HashMap;

public class RowWithMaxOnes {
    public int[] rowAndMaximumOnes(int[][] mat) {
        HashMap<Integer,Integer> rowMaxOne = new HashMap<>();

        for(int i =0;i < mat.length;i++){
            int count=0;
            for(int j=0;j<mat[i].length;j++){
                if(mat[i][j] == 1){
                    count++;
                }
            }
            rowMaxOne.put(i,count);
        }
        int[] ans = new int[2];
        int ones =0;
        for (int i=0;i<rowMaxOne.size();i++){

            if(rowMaxOne.get(i) > ones){
                ones = rowMaxOne.get(i);
                ans[0] = i;
                ans[1] = ones;

            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] mat = {{0,1},{1,0}};
        RowWithMaxOnes obj = new RowWithMaxOnes();
        System.out.println(Arrays.toString(obj.rowAndMaximumOnes(mat)));

    }
}
