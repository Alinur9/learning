package com.hridoy;

import java.util.Arrays;

public class BuyTwoChocolates {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
       int sum = prices[0] + prices[1];
       if(sum > money){
           return money;
       }
return money - sum;
    }

    public static void main(String[] args) {
        int[] prices = {1,2,2};
        int money = 3;
        BuyTwoChocolates obj = new BuyTwoChocolates();
        System.out.println(obj.buyChoco(prices,money));
    }
}
