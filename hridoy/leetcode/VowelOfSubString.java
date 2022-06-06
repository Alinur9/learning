package leetcode.com.company;


import java.util.HashSet;
import java.util.Set;

public class VowelOfSubString {

    public int countVowelSubstrings(String word) {
       Set<Character> set = new HashSet<>();
       int vow = 0;
       int n = word.length();
       for ( int i = 0 ; i < n -4 ; i++){
           set.clear();
           for (int j =i ; j < n ; j++){
               char ch = word.charAt(j);
               if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                   set.add(ch);
               if (set.size() == 5)
                   vow ++;
               }
               else break;
           }
       }
       return vow;
    }

    public static void main(String[] args) {
        String vowel = "cuaieuouac";
        VowelOfSubString obj = new VowelOfSubString();
        System.out.println(obj.countVowelSubstrings(vowel));
    }
}
