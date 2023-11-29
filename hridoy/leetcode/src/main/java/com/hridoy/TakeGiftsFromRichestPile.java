package com.hridoy;

public class TakeGiftsFromRichestPile {
    public long pickGifts(int[] gifts, int k) {

        long remainingGifts=0;
        while(k !=0){
            int max =0;
            int idx =0;
            for(int i=0;i<gifts.length;i++){
                if (gifts[i] > max){
                    max = gifts[i];
                    idx =i;
                }
            }
            double sqrt = Math.sqrt(max);
            int intSqrt = (int) sqrt;
            gifts[idx] = intSqrt;
            k--;
        }
        for (int i=0;i<gifts.length;i++){
            remainingGifts+=gifts[i];
        }
        return remainingGifts;
    }

    public static void main(String[] args) {
        int[] gifts = {25,64,9,4,100};
        int k = 4;
        TakeGiftsFromRichestPile obj = new TakeGiftsFromRichestPile();
        System.out.println(obj.pickGifts(gifts,k));

    }
}
