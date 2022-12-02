package diff.medium.contest;

public class LongestPalindromicSubStr {
    public String longestPalindrome(String s) {
    String longest= "";
        String ans = "";
        if (s.length() ==1){
            return s;
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1 ; j < s.length(); j++) {
                String temp = s.substring(i,j+1);
              ans =   palindrome(temp);
        if (ans.length() > longest.length()){
            longest = ans;
        }


            }
            if (longest.length() > s.length() - i){
                return longest;
            }
        }
        if(longest.length() > ans.length()){
            return longest;
        }
        return ans;
    }
    public String palindrome (String s1 ){
        String ans ="";
        int Idx = s1.length()-1;
        int firstIdx = 0;
        int lastIdx = 0;
        for (int i =0 ; i < s1.length()/2;++i){
            if (s1.charAt(i) == s1.charAt(Idx)){
                Idx--;
                firstIdx++;
                lastIdx ++;
                if ( firstIdx == lastIdx && i +1 == s1.length()/2 || firstIdx == s1.length()/2 ) {
                    ans = s1;
                }

            }else {
                return String.valueOf( s1.charAt(0));
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "bab";
        LongestPalindromicSubStr obj = new LongestPalindromicSubStr();
        System.out.println(obj.longestPalindrome(s));

    }
}
