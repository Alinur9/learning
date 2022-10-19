package com.hridoy;

public class BestPockerHand {

    public String bestHand(int[] ranks, char[] suits) {
        int cardRank =1;
        int pockerHand =0;
        boolean suitsFlag = true;

        for (int i =0; i < ranks.length-1;i++){
            if (suits[i] != suits[i+1]){
                suitsFlag = false;
            }
          for (int j =i+1; j < ranks.length;j++ ){
              if (ranks[i] == ranks[j]){
                  cardRank++;
              }
          }
          pockerHand = Math.max(pockerHand,cardRank);
          cardRank =1;
        }
        if (pockerHand <2 && suitsFlag ){
            return "Flush";
        }
        if (pockerHand > 3 || pockerHand == 3 ){
            return "Three of a Kind";
        }
        if (pockerHand == 2){
            return "Pair";
        }
        return "High Card";
    }

    public static void main(String[] args) {

        int [] ranks = {2,10,7,10,7};
       char [] suits = {'a','a','a','a','a'};

        BestPockerHand obj = new BestPockerHand();
        System.out.println(obj.bestHand(ranks,suits));

    }
}
