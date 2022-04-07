public class LCP2 {
    public  String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String p1 = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String p2 = strs[i];
            int j = 0;
            while (j < p2.length() && j < p1.length() && p2.charAt(j) == p1.charAt(j)) {
                j++;
            }
            if (j == 0)
                return "";
            p1 = p1.substring(0, j);
        }
        return p1;
    }
    public static void main (String[] args ){
        String[] pass = {"flower","flight","flow"};
        LCP2 c = new LCP2();
        c.longestCommonPrefix(pass);
        System.out.println(c.longestCommonPrefix(pass));

    }
}
