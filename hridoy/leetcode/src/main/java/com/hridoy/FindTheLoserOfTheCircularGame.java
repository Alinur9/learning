package com.hridoy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FindTheLoserOfTheCircularGame {
    public int[] circularGameLosers(int n, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=1;i<=n ;i++){
            map.put(i,0);
        }
        int j=1;
        map.put(j,1);
        while(map.get(j) !=2){

              j =  (j + k) % n;
              k = k*2;
         if(j ==0){
             j=1;
         }
        map.put(j,map.get(j)+1);

        }
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=map.size();i++){
            if(map.get(i) == 0){
                list.add(i);
            }
        }
        int[] loser = new int[list.size()];
        int ind =0;
        for(int l=0;l <= n;l++){
            if(list.contains(l)){
                loser[ind] = l;
                ind++;
            }
        }

return loser;
    }

    public static void main(String[] args) {
        int n =2;
        int k=1;
        FindTheLoserOfTheCircularGame obj = new FindTheLoserOfTheCircularGame();
        System.out.println(Arrays.toString(obj.circularGameLosers(n, k)));
    }
}
