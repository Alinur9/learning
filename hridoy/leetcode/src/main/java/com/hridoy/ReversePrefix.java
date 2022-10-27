package com.hridoy;

public class ReversePrefix {

    public String reversePrefix(String word, char ch) {

        StringBuilder sb = new StringBuilder();
        int idx = word.indexOf(ch);
        for (int i =idx; i >=0 ; i -- ){

            sb.append(word.charAt(i));
        }
        String temp = word.substring(idx+1);
        String getSb = sb.toString();
        String ans = getSb+temp;
        if (!ans.isEmpty()){
            return ans;
        }
        return word;

    }
        public static void main(String[] args) {

            String s = "abcdefd";
            char ch = 'd';

            ReversePrefix obj = new ReversePrefix();
            System.out.println(obj.reversePrefix(s,ch));


    }
}
