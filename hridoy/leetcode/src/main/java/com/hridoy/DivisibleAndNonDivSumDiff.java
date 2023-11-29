package com.hridoy;

public class DivisibleAndNonDivSumDiff {
    public int differenceOfSums(int n, int m) {
        int sum1=0;
        int sum2=0;
        for (int i=0;i<=n;i++){
            if(i%m==0){
                sum2+=i;
            }else {
                sum1+=i;
            }
        }
return sum1 - sum2;
    }
    public static void main(String[] args) {
        int n =5;
        int m =1;
        DivisibleAndNonDivSumDiff obj = new DivisibleAndNonDivSumDiff();
        System.out.println(obj.differenceOfSums(n,m));

    }
}
