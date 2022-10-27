package com.hridoy;

public class FindTheDisValBetwTowArr {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = arr1.length;
        for (int i =0; i < arr1.length;i++){
            for (int j =0; j < arr2.length;j++){
                int diff = Math.abs(arr1[i] - arr2[j]);
                if (diff <= d){
                    count--;
                    break;
                }
            }
        }
        return count;
    }
        public static void main(String[] args) {
        int[] arr1 ={1,4,2,3};
        int[] arr2 ={-4,-3,6,10,20,30};
                int d = 3;

                FindTheDisValBetwTowArr obj = new FindTheDisValBetwTowArr();
            System.out.println(obj.findTheDistanceValue(arr1,arr2,d));
    }
}
