package com.hridoy;

public class PassThePillow {
    public int passThePillow(int n, int time) {
        int holdingPerson = 1;
        boolean back = false;
        while (time != 0) {
            time--;
            if(holdingPerson != n && !back ) {
                holdingPerson++;
            }else {
                holdingPerson--;
                back = true;

            }
            if(holdingPerson == 1){
                back = false;
            }

        }
        return holdingPerson;
    }

    public static void main(String[] args) {
        int n = 18;
        int time =38;
        PassThePillow obj = new PassThePillow();
        System.out.println(obj.passThePillow(n,time));

    }
}
