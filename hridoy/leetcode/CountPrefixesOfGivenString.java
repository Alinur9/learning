package leetcode.com.company;

public class CountPrefixesOfGivenString {

    public int countPrefixes(String[] words, String s) {

        int count =0;
        for (String temp : words) {

            if (temp.length() <= s.length()) {
                String s1 = s.substring(0, temp.length());

                if (s1.equals(temp)) {
                    count++;
                }
            }

            }
        return count;
    }

    public static void main(String[] args) {
        String[] words = {"e","s","mi","e","ia","ibwu","e","e","k","ci","rip","suw","a","l",};
        String s = "e";
        CountPrefixesOfGivenString obj = new CountPrefixesOfGivenString();
        System.out.println(obj.countPrefixes(words,s));
    }
}
