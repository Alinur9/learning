package com.hridoy;

public class NumberOfWayBuy {

    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long result = 0;
        for (int i = 0; i <= total / cost1; i++) {
            long penAmount = i * cost1;
            long numPencils = (total - penAmount) / cost2;
            result = result + numPencils + 1;
        }
        return result;


        }

    public static void main(String[] args) {
        int total = 20;
        int cost1 = 5;
        int cost2 = 10;

        NumberOfWayBuy obj = new NumberOfWayBuy();
        System.out.println(obj.waysToBuyPensPencils(total,cost1,cost2));

    }
}
