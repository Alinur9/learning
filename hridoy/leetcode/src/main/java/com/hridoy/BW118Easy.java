package com.hridoy;

import java.util.ArrayList;
import java.util.List;

public class BW118Easy {
    public List<Integer> findWordsContaining(String[] words, char x) {

        List<Integer> list = new ArrayList<>();
        int i=0;
        for(String str : words){
            if(str.indexOf(x) != -1){
                list.add(i);
            }
            i++;
        }
return list;
    }

    public static void main(String[] args) {
        BW118Easy obj = new BW118Easy();
       String[] words = {"leet","code"};
       char x = 'e';
        System.out.println(obj.findWordsContaining(words,x));
    }
}
