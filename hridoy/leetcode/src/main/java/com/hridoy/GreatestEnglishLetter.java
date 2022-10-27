package com.hridoy;

public class GreatestEnglishLetter {
    public String greatestLetter(String s) {
        String s1 ="";
        char c = 'A';
        int count =0;
        for (int i =0;i<s.length();i++) {
            char ch = s.charAt(i);
            for (int j = i + 1; j < s.length(); j++) {
                char ch1 = s.charAt(j);
                if (Character.isLowerCase(ch)) {
                    if (!Character.isLowerCase(ch1)) {
                        if (Character.toLowerCase(ch1) == ch) {

                            if (c == ch1|| ch1 > c){
                                c = ch1;
                                count ++;
                            }
                        }
                    }
                }
                if (Character.isUpperCase(ch)) {
                    if (!Character.isUpperCase(ch1)) {
                        if (Character.toUpperCase(ch1) == ch) {
                            if (c == ch|| ch > c){
                                c = ch;
                                count++;
                            }
                        }
                    }
                }
            }
        }
        if (count> 0){

            return  String.valueOf(c);
        }
        return s1 ;
    }
    public static void main(String[] args) {
        String s = "arRAzFif";

        GreatestEnglishLetter obj = new GreatestEnglishLetter();
        System.out.println(obj.greatestLetter(s));

    }
}
