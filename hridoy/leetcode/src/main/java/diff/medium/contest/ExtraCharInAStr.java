package diff.medium.contest;

public class ExtraCharInAStr {
    public int minExtraChar(String s, String[] dictionary) {
        int extraChar = s.length();

        for (int i = 0; i < dictionary.length; i++) {
            if (dictionary[i].length() > extraChar) {
                continue;
            }

            for (int j = 0; j <= s.length() - dictionary[i].length(); j++) {
                String subStr = s.substring(j, j + dictionary[i].length());
                if (subStr.equals(dictionary[i])) {
                    extraChar -= dictionary[i].length();
                    break;
                }
            }
        }

        return extraChar;
    }
    public static void main(String[] args) {
    String s = "leetscode";
    String[] dic = {"leet","code","leetcode"};
    ExtraCharInAStr obj = new ExtraCharInAStr();
        System.out.println(obj.minExtraChar(s,dic));
    }
}
