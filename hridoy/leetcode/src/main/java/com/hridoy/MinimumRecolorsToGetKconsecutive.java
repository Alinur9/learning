package com.hridoy;

public class MinimumRecolorsToGetKconsecutive {
    public int minimumRecolors(String blocks, int k) {

        int recolors =0;
        int min =100;
        int b =0;

        for (int i=0;i < blocks.length();i++){
            if (i + k > blocks.length()){
                return min;
            }
           String s  = blocks.substring(i,i+k);
           for (int j=0; j < s.length();j++){
               if (s.charAt(j) == 'B'){
                   b++;
                   if (b == k){
                       return 0;
                   }
               }
               if (s.charAt(j) == 'W'){
                   recolors++;
               }
           }
           min = Math.min(min,recolors);
           recolors =0;
           b =0;
        }
        return min;
    }
    public static void main(String[] args) {
    String blocks = "BWWWBB";
    int k =2;

    MinimumRecolorsToGetKconsecutive obj = new MinimumRecolorsToGetKconsecutive();
        System.out.println(obj.minimumRecolors(blocks,k));
    }
}
