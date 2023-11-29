package com.hridoy;

public class FindTheLongestBalancedSubString {

    public int findTheLongestBalancedSubstring(String s) {
        int longestSubString =0;
        int zero=0;
        int one =0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '0'){
                zero++;
                if(i+1 < s.length() && s.charAt(i+1) == '1') {
                    while (i+1 < s.length() && s.charAt(i+1) != '0' ) {
                      one++;
                     i++;
                    }
                    int min = Math.min(zero,one);
                    if(min*2 > longestSubString ){
                        longestSubString = min*2;
                    }
                    zero=0;
                    one=0;

                }


            }
        }
        return longestSubString;
    }

    public static void main(String[] args) {
    String s = "0";
    FindTheLongestBalancedSubString obj = new FindTheLongestBalancedSubString();
        System.out.println(obj.findTheLongestBalancedSubstring(s));
    }
}
