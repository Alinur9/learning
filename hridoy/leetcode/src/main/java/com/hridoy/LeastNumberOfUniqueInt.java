package com.hridoy;

import java.util.Arrays;

public class LeastNumberOfUniqueInt {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        int count =0 ;
        if (k ==0 ){
            return count;
        }
        char temp = 'a';
        String s = Arrays.toString(arr).replaceAll("[-,-[-]-]","");

        for (int i=0;i< arr.length;i++){
            if (s.charAt(i) != temp) {
                int idx = s.indexOf(s.charAt(i));
                int idx2 = s.lastIndexOf(s.charAt(i));
                if (idx == idx2) {
                    count++;
                    continue;
                }
            }
            temp = s.charAt(i);

        }
        return count;

    }
    public static void main(String[] args) {
        int [] arr = {2,1,1,3,3,3};
        int k =2;
        LeastNumberOfUniqueInt obj = new LeastNumberOfUniqueInt();
        System.out.println(obj.findLeastNumOfUniqueInts(arr,k));

    }
}
