package com.hridoy;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {

        s = s.replaceAll("[^a-zA-Z0-9]","");
        String lower =  s.toLowerCase();
        int j = lower.length()-1;




        for (int i = 0 ; i < lower.length()-1; i++){
            if (lower.charAt(i) != lower.charAt(j)){
                return false;
            }
            if(lower.charAt(i) == lower.charAt(j)){
                if (j == i){
                    return true;
                }
                j--;
            }


            }

            return true;

    }

    public static void main(String[] args) {

        String s = " ";

        ValidPalindrome obj = new ValidPalindrome();
        System.out.println(obj.isPalindrome(s));

    }
}
