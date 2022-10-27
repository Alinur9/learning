package com.hridoy;

import java.util.HashMap;

public class CheckDistanceBetweenSameLetters {
    public boolean checkDistances(String s, int[] distance) {

        HashMap<Character,Integer> map = new HashMap<>();
        int spaced =0;
        String ch = "abcdefghijklmnopqrstuvwxyz";
        for (int i =0; i < s.length();i++){
            int firstIdx = s.indexOf(s.charAt(i));
            int lastIdx = s.lastIndexOf(s.charAt(i));
                spaced = (lastIdx - firstIdx)-1;
                if (!map.containsKey(s.charAt(i))){
                    map.put(s.charAt(i),spaced);
            }
                for (int j =0; j < distance.length; j++){
                  if (  map.containsKey(ch.charAt(j)) && map.get(ch.charAt(j)) != distance[j]){
                      return false;
                    }
                }
        }
    return true;
    }


    public static void main(String[] args) {

        String s = "abaccb";
        int[] distance = {1,3,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

        CheckDistanceBetweenSameLetters obj = new CheckDistanceBetweenSameLetters();
        System.out.println(obj.checkDistances(s,distance));
    }
}
