package com.hridoy;

import java.util.HashSet;
import java.util.Set;

public class BinaryCodesOfSizeK {

    public boolean hasAllCodes(String s, int k) {

        Set<String> set = new HashSet<>();
           int i =0;
            while ( i <= s.length()-k ){
                String sub = s.substring(i, i+k);
                set.add(sub);
                if (set.size() == Math.pow(2,k)){
                    return true;
            }
                i++;
        }
        return false;

    }
    public static void main(String[] args) {
        String s = "00110110";
        int k =2;

        BinaryCodesOfSizeK obj = new BinaryCodesOfSizeK();
        System.out.println(obj.hasAllCodes(s,k));
    }
}
