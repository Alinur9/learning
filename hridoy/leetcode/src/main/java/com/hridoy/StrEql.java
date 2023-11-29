package com.hridoy;

public class StrEql {
    public int findMinimumOperations(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();

        int maxLen = Math.max(len1, Math.max(len2, len3));

        // Step 1: Make lengths equal
        s1 = makeLengthEqual(s1, maxLen);
        s2 = makeLengthEqual(s2, maxLen);
        s3 = makeLengthEqual(s3, maxLen);

        // Step 2: Check for equality
        if (s1.equals(s2) && s2.equals(s3)) {
            return maxLen - len1 + maxLen - len2 + maxLen - len3;
        } else {
            return -1;
        }
    }

    private static String makeLengthEqual(String s, int targetLength) {
        while (s.length() > targetLength) {
            s = s.substring(0, s.length() - 1);
        }
        return s;
    }


    public static void main(String[] args) {
        String a = "abc";
        String b ="abd";
        String c = "ab";

        StrEql obj = new StrEql();

        System.out.println(obj.findMinimumOperations(a,b,c));

    }
}
