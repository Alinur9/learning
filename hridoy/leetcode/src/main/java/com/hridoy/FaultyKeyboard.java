package com.hridoy;

public class FaultyKeyboard {
    public String finalString(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
          if(s.charAt(i) != 'i'){
              sb.append(s.charAt(i));
          }else {
              StringBuilder reverse = new StringBuilder();
             for(int j =sb.length()-1;j>=0;j--){
                 reverse.append(sb.charAt(j));
             }
             sb = reverse;
          }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String s = "poiinter";
        FaultyKeyboard obj = new FaultyKeyboard();
        System.out.println(obj.finalString(s));
    }
}
