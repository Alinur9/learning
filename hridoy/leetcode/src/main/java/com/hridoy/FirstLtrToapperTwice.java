package com.hridoy;

public class FirstLtrToapperTwice {
    public char repeatedCharacter(String s) {
            int minIdx = 100;
        for (int i =0; i < s.length();i++){
            for (int j =i+1;j < s.length();j++){
                if (s.charAt(i) == s.charAt(j)){
                    minIdx = Math.min(minIdx,j);
                }
            }
        }
        return s.charAt(minIdx);
    }
    public static void main(String[] args) {
        String s = "abccbaacz";

        FirstLtrToapperTwice obj = new FirstLtrToapperTwice();
        System.out.println(obj.repeatedCharacter(s));

    }
}
