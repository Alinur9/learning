package com.hridoy;

public class CountAsterisks {

    public int countAsterisks(String s) {
        int asterisks =0;
        int length = s.length();
        for (int i =0;i<length;i++){
            if (s.charAt(i) != '|' && s.charAt(i) == '*'){
                asterisks++;
            }
            int j =i+1;
            if (s.charAt(i) == '|') {
                while(j != length && s.charAt(j) != '|') {
                    j++;
                }
                i = j;
            }


            }
        return asterisks;

    }
    public static void main(String[] args) {

        String s = "||||ftrsg||**|||||****|**";
        CountAsterisks obj = new CountAsterisks();
        System.out.println(obj.countAsterisks(s));

    }
}
