package diff.medium.contest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OptimalPartitionOfString {
    public int partitionString(String s) {

        int count =1;
        HashSet<Character> st = new HashSet<>();
        for (int i =0; i < s.length();i++){
            if (!st.contains(s.charAt(i))){
                st.add(s.charAt(i));
            }else {
                count++;
                st.clear();
                st.add(s.charAt(i));
            }
        }
        return count;

    }

    public static void main(String[] args) {

        String s = "abacaba";
        OptimalPartitionOfString obj = new OptimalPartitionOfString();
        System.out.println(obj.partitionString(s));

    }
}
