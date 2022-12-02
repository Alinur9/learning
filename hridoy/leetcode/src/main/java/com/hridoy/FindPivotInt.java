package com.hridoy;

public class FindPivotInt {
    public int pivotInteger(int n) {
        int sum1 =0;
        boolean check =false ;
        for (int i =1; i <= n ;i++){

            sum1 += i;
             check = sum2(i,n,sum1);
             if(check) {
                 return i;
             }
            }


        return -1;
    }
    public boolean sum2 (int i,int n , int sum1) {
    int sum2 =0;
    int count =0;
    for (int j = n ; j >0 ;j--) {
        count++;
        sum2+= j;

        if (sum2 == sum1 && i+count-1 == n){
            return true;
        }
    }
    return false;
    }

    public static void main(String[] args) {
        int n = 1;
        FindPivotInt obj = new FindPivotInt();
        System.out.println(obj.pivotInteger(n));
    }
}
