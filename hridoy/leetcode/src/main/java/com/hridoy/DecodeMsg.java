package com.hridoy;

import java.util.HashMap;

public class DecodeMsg {
    public String decodeMessage(String key, String message) {
        StringBuilder ans = new StringBuilder();
        key = key.replaceAll(" ","");

        HashMap<Character,Character> letters = new HashMap<>();
        char original = 'a';
        for (int i =0;i < key.length();i++){
            if (!letters.containsKey(key.charAt(i))){
                letters.put(key.charAt(i),original++);
            }
        }
        for (int i =0; i < message.length();i++){
            if (letters.containsKey(message.charAt(i))){
                ans.append(letters.get(message.charAt(i)));
            }else {
                ans.append(message.charAt(i));
            }
        }
        return ans.toString();
    }


    public static void main(String[] args) {

        String key = "the quick brown fox jumps over the lazy dog";
        String msg = "vkbs bs t suepuv";
        DecodeMsg obj = new DecodeMsg();
        System.out.println(obj.decodeMessage(key,msg));

    }
}
