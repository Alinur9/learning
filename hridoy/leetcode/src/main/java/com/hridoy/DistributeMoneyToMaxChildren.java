package com.hridoy;

public class DistributeMoneyToMaxChildren {
    public int distMoney(int money, int children) {

        if(children > money ){
            return -1;
        }
        int max = 0;
        if(money >= 8 && children * 8 == money){
            return children;
        }
        money -= children;

        if (money  < 7){
            return 0;
        }
    int j = children;
        for(int i=0;i<=j;i++){
                if(money - 7 == 3 && children ==2){
                    return max;
                }
                if(children ==1 && money > 7){
                    return max;
                }
                max++;
                children--;
                money-=7;
                if(money < 7){
                    return max;
                }
            }

        return max;
    }

    public static void main(String[] args) {
        int money =33;
        int children = 5;
        DistributeMoneyToMaxChildren obj = new DistributeMoneyToMaxChildren();
        System.out.println(obj.distMoney(money,children));

    }
}
