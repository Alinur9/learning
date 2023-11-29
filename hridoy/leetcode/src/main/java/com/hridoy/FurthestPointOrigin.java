package com.hridoy;

public class FurthestPointOrigin {
    public int furthestDistanceFromOrigin(String moves) {
        int distance = 0;
        int currentPos = 0;
        boolean r = false;
        boolean l = false;
        if(moves.charAt(0) == 'R'){
            r = true;
        }else if (moves.charAt(0) == 'L'){
            l = true;
        }

        for (char move : moves.toCharArray()) {
            if (move == 'R') {
                currentPos++;

            } else if (move == 'L' ) {
                currentPos--;
            } else if (r) {
                currentPos++;
            } else if (l) {
                currentPos--;
            } else {
                currentPos++;
            }

        }

        return  Math.abs(currentPos);
        }


    public static void main(String[] args) {

        String words = "L_RL__R";
        FurthestPointOrigin obj = new FurthestPointOrigin();
        System.out.println(obj.furthestDistanceFromOrigin(words));

    }
}
