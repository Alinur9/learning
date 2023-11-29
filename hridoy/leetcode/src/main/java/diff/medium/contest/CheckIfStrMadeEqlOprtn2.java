package diff.medium.contest;

public class CheckIfStrMadeEqlOprtn2 {
    public boolean checkStrings(String s1, String s2) {
        int n = s1.length();
        char[] s2Chars = s2.toCharArray();
        char[] s1Chars = s1.toCharArray();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((j - i) % 2 == 0) {
                    if ((s1Chars[i] == s2Chars[j] || s1Chars[j] == s2Chars[i])) {
                        char temp = s1Chars[i];
                        s1Chars[i] = s1Chars[j];
                        s1Chars[j] = temp;

                        temp = s2Chars[i];
                        s2Chars[i] = s2Chars[j];
                        s2Chars[j] = temp;
                    }
                }
            }
        }

        return false;
    }
    public static void main(String[] args) {
        String s1 = "abcdba";
        String s2 = "cabdab";

        CheckIfStrMadeEqlOprtn2 obj = new CheckIfStrMadeEqlOprtn2();
        System.out.println(obj.checkStrings(s1,s2));


    }
}
