package com.hridoy;

import java.util.ArrayList;

public class OddStringDiff {
    public String oddString(String[] words) {

        int n = words.length;
    ArrayList<String> list = new ArrayList<>();
        int ans =0;
        String s = "";
        int tr = 0;
        String a= "";
        String b= "";

        for (int i =0 ; i < n ;i++){
            for (int j =0; j < words[i].length()-1;j++){

                int first = getNum (words[i].charAt(j));
                int sec =getNum (words[i].charAt(j+1));
                 ans += sec - first;
                 s += String.valueOf(ans);
                 ans=0;
            }
            if(!a.isEmpty()&&!b.isEmpty()){
                if (a.equals(s)){
                    return words[i-2];
                }
                return words[tr];
            }
            if (!list.isEmpty() && !list.contains(s)){
                a = s;
                tr = i;
                b = list.get(i-1);
            }
       list.add(s);
            s= "";
        }


        return words[n-1];
    }
   public int getNum(char c){
        if(c == 'a'){
            return 0;
        } else if (c== 'b') {
            return 1;
        }else if (c== 'c') {
            return 2;
        }else if (c== 'd') {
            return 3;
        }else if (c== 'e') {
            return 4;
        }else if (c== 'f') {
            return 5;
        }else if (c== 'g') {
            return 6;
        }else if (c== 'h') {
            return 7;
        }else if (c== 'i') {
            return 8;
        }else if (c== 'j') {
            return 9;
        }else if (c== 'k') {
            return 10;
        }else if (c== 'l') {
            return 11;
        }else if (c== 'm') {
            return 12;
        }else if (c== 'n') {
            return 13;
        }else if (c== 'o') {
            return 14;
        }else if (c== 'p') {
            return 15;
        }else if (c== 'q') {
            return 16;
        }else if (c== 'r') {
            return 17;
        }else if (c== 's') {
            return 18;
        }else if (c== 't') {
            return 19;
        }else if (c== 'u') {
            return 20;
        }else if (c== 'v') {
            return 21;
        }else if (c== 'w') {
            return 22;
        }else if (c== 'x') {
            return 23;
        }else if (c== 'y') {
            return 24;
        }
       return 25;
    }

    public static void main(String[] args) {
        String[] words = {"adc","wzy","abc"};
        OddStringDiff obj = new OddStringDiff();
        System.out.println(obj.oddString(words));
    }
}
