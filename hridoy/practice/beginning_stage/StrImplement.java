public class StrImplement {
    public int str (String haystack, String needle){

        if(needle == null || needle.length()==0) return 0;
        if (haystack.length() < needle.length()  || !haystack.contains(needle))  return -1;
        for (int i = 0; i < haystack.length(); i++) {
            int j = 0;
            if (haystack.charAt(i) == needle.charAt(j)) {
                int len = 0;
                while (i + len < haystack.length() && len < needle.length() && haystack.charAt(i + len) == needle.charAt(len)) {
                    len++;
                    if (len == needle.length()) {
                        return i;
                    }
                }
            }
        }

        return -1;
    }
    public static void main (String[] args){
        String a = "tabassum";
        String b = "ss";
        int occ;
        StrImplement c = new StrImplement();
        occ=c.str(a,b);
        System.out.println(" "+ occ);
    }
}
