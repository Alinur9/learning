package com.hridoy;

public class W373Medium {
    public int beautifulSubstrings(String s, int k) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            int vowels = 0;
            int consonants = 0;

            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                if (isVowel(c)) {
                    vowels++;
                } else {
                    consonants++;
                }

                if (vowels == consonants && vowels * consonants % k == 0) {
                    count++;
                }
            }
        }

        return count;
    }

    private static boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }
    public static void main(String[] args) {
      String s = "baeyh";
      int k = 2;
      W373Medium obj = new W373Medium();
        System.out.println(obj.beautifulSubstrings(s,k));
    }
}
