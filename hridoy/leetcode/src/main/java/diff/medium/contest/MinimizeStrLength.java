package diff.medium.contest;

import java.util.HashSet;
import java.util.Set;

public class MinimizeStrLength {
    public int minimizedStringLength(String s) {

        int occ =0;
        Set<Character> c = new HashSet<>();
        for(int i=0;i<s.length();i++){
            String temp = String.valueOf(s.charAt(i));
           c.add(s.charAt(i));
        }
return c.size();
    }
    public static void main(String[] args) {
    String s = "dddaaa";
    MinimizeStrLength obj = new MinimizeStrLength();
        System.out.println(obj.minimizedStringLength(s));
    }
}
