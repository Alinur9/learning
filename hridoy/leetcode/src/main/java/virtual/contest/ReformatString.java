package virtual.contest;

public class ReformatString {
    public String reformat(String s) {
        StringBuilder cntLetters = new StringBuilder();
        StringBuilder cntDigits = new StringBuilder();
        StringBuilder reformatString = new StringBuilder();

        for (char c : s.toCharArray()){
            if (Character.isDigit(c)){
                cntDigits.append(c);
            }
            if (Character.isLowerCase(c)) {
                cntLetters.append(c);
            }
        }
        if (Math.abs( cntDigits.length() - cntLetters.length()) > 1){
            return "";
        }
        int i =0;
        int j =0;
        while (i +j != s.length()) {
            if (cntDigits.length() >= cntLetters.length()) {
                reformatString.append(cntDigits.charAt(i));
                i++;
                if (i+j != s.length()) {
                    reformatString.append(cntLetters.charAt(j));
                    j++;
                }
            }
            if (cntLetters.length() > cntDigits.length()){
                reformatString.append(cntLetters.charAt(i));
                i++;
                if (i+j != s.length()) {
                    reformatString.append(cntDigits.charAt(j));
                    j++;
                }
            }
        }
        return reformatString.toString();
    }

    public static void main(String[] args) {
        String s = "a0b1c2f";
        ReformatString obj = new ReformatString();
        System.out.println(obj.reformat(s));
    }
}
