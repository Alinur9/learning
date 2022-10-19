package com.hridoy;

import java.util.Arrays;

public class SortIntAscendByNumOfBits {
    public int[] sortByBits(int[] arr) {


        for(int i =0; i < arr.length;i++){
             int checkBits = (int)(Math.log(arr[i])/Math.log(2)+1);
             for (int j = 0; j < arr.length; j++){
                 int numOfBits =(int)(Math.log(arr[j]) / Math.log(2) + 1);
                 if (numOfBits > checkBits){
                     int temp = arr[i];
                     arr[i] = arr[j];
                     arr[j] = temp;
                 }
             }
        }
        return arr;

    }
    public static void main(String[] args) {
        int[] arr ={0,1,2,3,4,5,6,7,8};

        SortIntAscendByNumOfBits obj = new SortIntAscendByNumOfBits();
        System.out.println(Arrays.toString(obj.sortByBits(arr)));

    }
}
