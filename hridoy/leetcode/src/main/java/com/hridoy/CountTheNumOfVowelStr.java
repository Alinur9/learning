package com.hridoy;

public class CountTheNumOfVowelStr {
    public int vowelStrings(String[] words, int left, int right) {
        int vowel =0;
        for(int i=left;i<right+1;i++){
            boolean checkV = false;
            checkV = checkVowel(words[i]);
            if(checkV){
                vowel++;
            }
        }
        return vowel;

    }
    public boolean checkVowel(String s){
        char c = s.charAt(0);
        char c1 = s.charAt(s.length()-1);
        if(c =='a' || c== 'e' || c == 'i' || c == 'o' || c == 'u'){
            if(c1 =='a' || c1== 'e' || c1 == 'i' || c1 == 'o' || c1 == 'u') {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] words ={"are","amy","u"};
        int left= 0;
        int right= 2;

                CountTheNumOfVowelStr obj = new CountTheNumOfVowelStr();
        System.out.println(obj.vowelStrings(words,left,right));
    }
}
