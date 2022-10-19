package com.hridoy;

import java.util.Arrays;

public class GoatLatin {

    public String toGoatLatin(String sentence) {
        StringBuilder sb = new StringBuilder();
        String ma = "ma";
        String a = "a";
        int getpass1 = 0;
        int getpass2 = 3;
        String[] str = sentence.split(" ");

        for (int i =0 ; i < str.length; i++){

            str[i] += ma;
            String s = String.valueOf(str[i].charAt(0));

            for (int j = 0 ; j <= i ; j++){
                 if (str[i].length() > getpass2 ) {
                     if (str[i].charAt(0) != 'a' && str[i].charAt(0) != 'e' && str[i].charAt(0) != 'i' && str[i].charAt(0) != 'o' && str[i].charAt(0) != 'u' && str[i].charAt(0) != 'A' && str[i].charAt(0) != 'E' && str[i].charAt(0) != 'I' && str[i].charAt(0) != 'O' && str[i].charAt(0) != 'U') {
                         if (getpass1 == 0) {
                             str[i] = str[i].substring(1, str[i].length() - 2) + s + ma;
                             getpass1 = 1;
                         }
                     }
                 }
                str[i] += a;
                 getpass2++;
            }
            getpass2 =3;
            getpass1 =0;
            if (i != str.length-1) {
                str[i] += " ";
            }
            sb.append(str[i]);
        }
        String str1 = sb.toString();
        return str1;
    }

    public static void main(String[] args) {

        String s = "HZ sg L";
        GoatLatin obj = new GoatLatin();
        System.out.println(obj.toGoatLatin(s));

    }
}
