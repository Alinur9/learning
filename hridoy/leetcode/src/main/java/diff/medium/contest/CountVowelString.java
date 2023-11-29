package diff.medium.contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountVowelString {

    public int[] vowelStrings(String[] words, int[][] queries) {

        int n = words.length;

        int[] pref = new int[n];

        String s = words[0];
        if (isVowel(s.charAt(0)) && isVowel(s.charAt(s.length() - 1))) {
            pref[0] = 1;
        }

        for (int i = 1; i < n; i++) {
            s = words[i];

            if (isVowel(s.charAt(0)) && isVowel(s.charAt(s.length() - 1))) {

                pref[i] = 1 + pref[i-1];
            } else {
                pref[i] = pref[i-1];
            }
        }


        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            if(l == 0){
                ans[i] = pref[r];
            }else{
                ans[i] = pref[r] - pref[l-1];
            }
        }

        return ans;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args) {
        String[]words = {"aba","bcb","ece","aa","e"};
        int[][]queries={{0,2},{1,4},{1,1}};
        CountVowelString obj = new CountVowelString();
        System.out.println(Arrays.toString(obj.vowelStrings(words, queries)));
    }
}
