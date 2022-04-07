import java.util.ArrayList;
import java.util.List;

public class LCP {
    public String longestCommonPrefix(String[] strs) {
        List<String> al = new ArrayList<>();
        if (strs == null || strs.length== 1) return "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            int point = 0;
            for (int j = 1; j < strs.length; j++) {
                int index = strs[j].indexOf(c);
                if (index == -1) {
                    point = 1;
                    break;
                }
            }
            if (point == 0) {
                al.add(Character.toString(c));
            }
        }
        String k="";
        for( int i =0; i < al.size();i++){
            k = k + al.get(i);

        }
        return k;
    }
    public static void main (String[] args){
        String [] strs = {"kpow","flower","flight"};

        LCP c = new LCP();
       c.longestCommonPrefix(strs);
        System.out.println(c.longestCommonPrefix(strs));
    }
}
