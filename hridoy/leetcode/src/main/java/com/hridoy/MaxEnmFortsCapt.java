package com.hridoy;

public class MaxEnmFortsCapt {

    public int captureForts(int[] forts) {

        int maxForts =0;


        for (int i =0; i < forts.length;i++){
            if (forts[i] != 0) {
                if( getCounter(i,forts[i], forts) > maxForts){
                    maxForts = getCounter(i,forts[i], forts);
                }


            }
            }
return maxForts;
    }
        public int getCounter(int start,int fo, int[] forts){
            int count =0;
            for (int i = start+1;i < forts.length;i++){
                if (i == forts.length-1 && forts[i] == 0){
                    break;
                }
                if (forts[i] == 0){
                    count++;
                }else {
                    if (fo == forts[i] ){
                        count=0;
                    }
                    break;
                }
            }
            return count;
        }

    public static void main(String[] args) {
        int[] forts ={0,-1,-1,0,-1};

        MaxEnmFortsCapt obj = new MaxEnmFortsCapt();
        System.out.println(obj.captureForts(forts));

    }
}
