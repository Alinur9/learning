package com.hridoy;

public class FirstUnqChar {
    public int firstUniqChar(String s) {

        for(char c : s.toCharArray()){
            int index = s.indexOf(c);
            int lastIndex = s.lastIndexOf(c);
            if(index == lastIndex)
                return index;
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstUnqChar obj = new FirstUnqChar();
        String s = "loveleetcode";
        System.out.println(obj.firstUniqChar(s));
    }
}
