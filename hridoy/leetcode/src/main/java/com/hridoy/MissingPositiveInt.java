package com.hridoy;

public class MissingPositiveInt {
    public int findKthPositive(int[] arr, int k) {
        int sum =0;
        if ( arr[0]-1 >= k){
            return k;
        }
        if (arr[0] != 1 ){
            sum = arr[0]-1;
        }
        if (arr.length ==1){
            return sum;
        }

        int j =0;
        for (int i : arr){
            j++;
            if (j > arr.length-1){
                j--;
            }
            while (i < arr[j]) {
                if (i + 1 != arr[j]) {
                    i++;
                    sum++;
                }
                if (sum == k) {
                    return i;
                }
                if (i + 1 == arr[j]) {
                    break;
                }
            }

        }
        return arr[j] + k-sum;
    }

    public static void main(String[] args) {

        int k =2;
        int[] nums = {3,10};
        MissingPositiveInt obj = new MissingPositiveInt() ;
        System.out.println(obj.findKthPositive(nums,k));

    }
}
