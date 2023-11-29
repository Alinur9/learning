package com.hridoy;

public class KItemsWiththeMaximumSum {

    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        int max =0;
        for(int i =0;i<k;i++){
            if(numOnes != 0){
                max++;
                numOnes--;
            }else if(numZeros != 0){
              numZeros--;
            }else {
                max -= 1;
                numNegOnes--;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int numOnes = 3;
        int numZero = 0;
        int numNeg = 0;
        int k =4;

        KItemsWiththeMaximumSum obj = new KItemsWiththeMaximumSum();
        System.out.println(obj.kItemsWithMaximumSum(numOnes,numZero,numNeg,k));
    }
}
