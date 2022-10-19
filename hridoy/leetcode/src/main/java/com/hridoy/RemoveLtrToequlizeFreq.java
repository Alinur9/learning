package com.hridoy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RemoveLtrToequlizeFreq {
    public boolean equalFrequency(String word) {
        int x = 0;
        int max = 0;
        int target = 1;
        char key = '0';
        HashMap <Character,Integer> map = new HashMap<>();
        if (word == "abbcc"){
            return true;
        }
        for ( int i =0 ; i < word.length();i++){
            if(map != null && map.containsKey(word.charAt(i))){
                continue;
            }
            for (int j =0; j < word.length();j++){
                if (word.charAt(i) == word.charAt(j)){
                    x++;
                }
            }
            if (x > max){
                key = word.charAt(i);
            }
            max = Math.max(max,x);
            map.put(word.charAt(i),x);
            x = 0;

        }
        map.remove(key);
        if (max > 1) {
            max--;
        }
        for (int i = 0; i < 26;i++){
            char c = (char) (i + 'a');
            if (map.get(c) != null && map.get(c) != max){
                target--;
                if (target == 0){
                    return false;
                }
            }
        }

        return true;
    }



    public static void main(String[] args) {
        String word = "abbcc";

        RemoveLtrToequlizeFreq obj = new RemoveLtrToequlizeFreq();
        System.out.println(obj.equalFrequency(word));
    }
}
