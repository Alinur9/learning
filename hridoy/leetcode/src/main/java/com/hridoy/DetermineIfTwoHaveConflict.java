package com.hridoy;

public class DetermineIfTwoHaveConflict {
    public boolean haveConflict(String[] event1, String[] event2) {


        String[] ev1S ;
        String[] ev1E ;
        String[] ev2S ;
        String[] ev2E ;

        ev1S = event1[0].split(":");
        ev1E = event1[1].split(":");
        ev2S = event2[0].split(":");
        ev2E = event2[1].split(":");

        float evenHS1 = Float.parseFloat(ev1S[0]);
        float evenMS1 = Float.parseFloat(ev1S[1]);
        float evenHE1 = Float.parseFloat(ev1E[0]);
        float evenME1 = Float.parseFloat(ev1E[1]);
        float evenHS2 = Float.parseFloat(ev2S[0]);
        float evenMS2 = Float.parseFloat(ev2S[1]);
        float evenHE2 = Float.parseFloat(ev2E[0]);
        float evenME2 = Float.parseFloat(ev2E[1]);


        evenHS1 = evenHS1 * 60 + evenMS1;
        evenHE1 = evenHE1 * 60 + evenME1;
        evenHS2 = evenHS2 * 60 + evenMS2;
        evenHE2 = evenHE2 * 60 + evenME2;

        if ( evenHS2 <= evenHE1  && evenHE2 >= evenHS1){
            return true;
        }


  return false;


    }

    public static void main(String[] args) {
        String[] event1 = {"06:45","21:28"};
        String[] event2 = {"02:11","22:26"};
        DetermineIfTwoHaveConflict obj = new DetermineIfTwoHaveConflict();
        System.out.println(obj.haveConflict(event1,event2));

    }
}
