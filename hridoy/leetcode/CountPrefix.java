package leetcode.com.company;

public class CountPrefix {
    public int prefixCount(String[] words, String pref) {
        int count =0;
        int pLeng = pref.length();
        String temp;
        for( int i = 0 ; i < words.length ; i++){
            if (words[i].length() >= pLeng) {
                temp = words[i].substring(0,pLeng);
                if ( temp.equals(pref)){
                    count++;
            }
            }
        }
        return count;

    }

    public static void main(String[] args) {
        String[] words = {"leetcode","win","loops","success"};
        String pref = "code";
        CountPrefix obj = new CountPrefix();
        int res;
       res = obj.prefixCount(words,pref);
        System.out.println(res);
    }
}
