package com.hridoy;

public class SuffleString {
    public String restoreString(String s, int[] indices) {

        int n = s.length();
        char[] ch = new char[s.length()];
        for (int i =0 ; i < n ; i++){
            for (int j =0 ; j< n ; j++){
                if ( indices[j] == i){
                    ch[i] = s.charAt(j);
                    break;
                }
            }
        }
        String ans = String.valueOf(ch);
        return ans;

    }
    public static void main(String[] args) {
        String s = "codeleet";
        int[] indices = {4,5,6,7,0,2,1,3};
        SuffleString obj = new SuffleString();
        System.out.println(obj.restoreString(s,indices));

    }
}
