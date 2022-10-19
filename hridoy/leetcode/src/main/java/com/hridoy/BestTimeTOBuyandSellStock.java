package com.hridoy;

public class BestTimeTOBuyandSellStock {
    public int maxProfit(int[] prices) {

        int len = prices.length;
       int day1 = prices[0];
       int day2 =0;

       for (int i =1; i < len; i++){
           if (prices[i] - day1 > day2){
               day2 = prices[i] - day1;
           }
           if (prices[i] < day1){
               day1 = prices[i];
           }
        }
       return day2;


    }


    public static void main(String[] args) {

        BestTimeTOBuyandSellStock obj = new BestTimeTOBuyandSellStock();
        int [] prices = {7,6,4,30,1};

        System.out.println(obj.maxProfit(prices));
    }
}
