package com.hridoy;

public class DetermineIfTwoHaveConflict {
    public boolean haveConflict(String[] event1, String[] event2) {
        int c1 = event2[0].compareTo(event1[1]);
        int c2 = event2[1].compareTo(event1[0]);

        return (c1 <= 0) && (c2 >= 0);
    }

    public static void main(String[] args) {
        String[] event1 = {"06:45","21:28"};
        String[] event2 = {"02:11","22:26"};
        DetermineIfTwoHaveConflict obj = new DetermineIfTwoHaveConflict();
        System.out.println(obj.haveConflict(event1,event2));

    }
}
