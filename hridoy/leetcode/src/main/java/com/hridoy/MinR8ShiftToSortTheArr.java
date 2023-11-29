package com.hridoy;

import java.util.ArrayList;
import java.util.List;

public class MinR8ShiftToSortTheArr {
    public int minimumRightShifts(List<Integer> nums) {
        int n = nums.size();

        // Find the starting point of the sorted sequence
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = nums.get(i);
        }
        int count=0;
        int count1=0;
        for(int i=0;i<n-1;i++){
            if(arr[i] < arr[i+1]){
                count1++;
            }
        }
        if(count1+1 ==n ){
            return 0;
        }

        for(int i=0;i < n;i++){
            nums.clear();
            for(int j=i;j<n+i;j++){
                nums.add(arr[(j) % n]);
            }
            for(int k=0;k<n-1;k++){
                if(nums.get(k) < nums.get(k+1)){
                    count++;
                }
            }
            if(count+1 == n){
                return  n -i;
            }
            count=0;
        }
return -1;
    }
    public static void main(String[] args) {
    List<Integer> arr = new ArrayList<>();
    arr.add(3);
    arr.add(4);
    arr.add(5);
    MinR8ShiftToSortTheArr obj = new MinR8ShiftToSortTheArr();
        System.out.println(obj.minimumRightShifts(arr));
    }
}
