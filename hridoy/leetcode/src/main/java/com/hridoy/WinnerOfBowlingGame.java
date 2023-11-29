package com.hridoy;

public class WinnerOfBowlingGame {

    public int isWinner(int[] player1, int[] player2) {
        int power1 =0;
        int power2 =0;
        int p1Sum =0;
        int p2Sum =0;
        for(int i=0;i <player1.length;i++){
            if(power1 >0){
                p1Sum += player1[i]*2;
                power1--;
                if(player1[i] == 10){
                    power1 = 2;
                }
            }else {
                p1Sum+= player1[i];
                if(player1[i] == 10){
                    power1 = 2;
                }
            }
            if(power2 >0){
                p2Sum += player2[i]*2;
                power2--;
                if(player2[i] == 10){
                    power2 = 2;
                }
            }else {
                p2Sum+= player2[i];
                if(player2[i] == 10){
                    power2 = 2;
                }
            }
        }
        if(p1Sum > p2Sum){
            return 1;
        } else if (p2Sum > p1Sum) {
            return 2;
        }
        return 0;
    }

    public static void main(String[] args) {
    int[] p1= {7,10,2,6,8,5,4,6,10,9,1,4,3,10,0,9,6,1,0};
    int[] p2= {2,1,9,4,5,0,6,5,6,10,10,4,8,8,6,9,2,9,5};

    WinnerOfBowlingGame obj = new WinnerOfBowlingGame();
        System.out.println(obj.isWinner(p1,p2));
    }
}
