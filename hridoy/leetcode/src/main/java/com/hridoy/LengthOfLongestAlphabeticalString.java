package com.hridoy;

public class LengthOfLongestAlphabeticalString {
    public int longestContinuousSubstring(String s) {

        String alpbCont = "abcdefghijklmnopqrstuvwxyz";
        int max = 0;
        int count =1;
        boolean track = true;
        int idx =0;

        for (int i =0 ; i < s.length()-1;i++){
            if (track ==true) {
                char chaIdx = s.charAt(i);
                idx = alpbCont.indexOf(chaIdx);
            }
            if (idx+1 <alpbCont.length()&& alpbCont.charAt(idx+1) == s.charAt(i+1)){
                idx++;
                count ++;
                track =false;
            }else {
                max = Math.max(count,max);
                count =1;
                track = true;
            }
        }
        return  Math.max(count,max);


    }

    public static void main(String[] args) {
        String s = "zyrpjofyzubfsiwxyz";
        LengthOfLongestAlphabeticalString obj = new LengthOfLongestAlphabeticalString();
        System.out.println(obj.longestContinuousSubstring(s));

    }
}
