package com.hridoy;

public class AccBalnRounded {
    public int accountBalanceAfterPurchase(int purchaseAmount) {
        int roundedAmount = (int) Math.ceil(purchaseAmount / 10.0) * 10;
        int diff = Math.abs(roundedAmount - purchaseAmount);
        if (diff > 5) {
            roundedAmount -= 10;
        }
        return 100 - roundedAmount;
    }
    public static void main(String[] args) {
        int dollars =11;
        AccBalnRounded obj = new AccBalnRounded();
        System.out.println(obj.accountBalanceAfterPurchase(dollars));
    }
}
