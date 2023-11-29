package com.hridoy;

public class CircularSentence {

    public boolean isCircularSentence(String sentence) {
        String[] words = sentence.split(" ");
        char firstChar = sentence.charAt(0);
        char lastChar = sentence.charAt(sentence.length()-1);
        if (firstChar!= lastChar){
            return false;
        }
        for (int i =0; i < words.length-1;i++){
            char last =words[i].charAt(words[i].length()-1);
            char fast =  words[i+1].charAt(0);
            if (last != fast){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String sentence = "leetcode exercises sound delightful";
        CircularSentence obj = new CircularSentence();
        System.out.println(obj.isCircularSentence(sentence));
    }
}
