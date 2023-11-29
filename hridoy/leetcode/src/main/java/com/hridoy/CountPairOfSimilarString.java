package com.hridoy;

import java.util.HashSet;

public class CountPairOfSimilarString {
    public int similarPairs(String[] words) {
      int  pairs =0;
        for (int i=0;i< words.length;i++){
           pairs += getPairs(words[i],i,words );
        }
        return pairs;
    }
    public int getPairs(String value,int position,String[] words){
        HashSet<Character> set = new HashSet<>();
        HashSet<Character> set2 = new HashSet<>();
        int size=value.length();
        int pairs =0;

        for(int c =0; c < size;c++){
            set.add(value.charAt(c));
        }
        for (int j=position+1;j < words.length;j++){
            boolean flag = true;
            for(int i=0;i<words[j].length();i++){

                if (!set.contains(words[j].charAt(i))){
                    flag = false;
                    break;
                }else {
                    set2.add(words[j].charAt(i));
                }
            }
            if(flag && set.size() == set2.size()){
                pairs++;
                set2.clear();
            }
            set2.clear();
        }

        return pairs;
    }

    public static void main(String[] args) {
        String [] words = {"dcedceadceceaeddcedc","dddcebcedcdbaeaaaeab","eecbeddbddeadcbbbdbb","decbcbebbddceacdeadd","ccbddbaedcadedbcaaae","dddcaadaceaedcdceedd","bbeddbcbbccddcaceeea","bdabacbbdadabbbddaea"};
        CountPairOfSimilarString obj = new CountPairOfSimilarString();
        System.out.println(obj.similarPairs(words));
    }
}
