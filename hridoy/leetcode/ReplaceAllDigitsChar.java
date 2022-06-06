package leetcode.com.company;
public class ReplaceAllDigitsChar {

    public String replaceDigits(String s) {

        StringBuilder sb = new StringBuilder(s.length());
        for (int i =0; i < s.length() ; i++){
            char current = s.charAt(i);
            if (Character.isDigit(current)){
                sb.append((char) (s.charAt(i-1) + Character.getNumericValue(current)) );
            }
            else {
                sb.append(current);
            }
        }
        return sb.toString();


    }


        public static void main(String[] args) {

        String s = "a1c1e1";

        ReplaceAllDigitsChar obj = new ReplaceAllDigitsChar();
            System.out.println(obj.replaceDigits(s));

    }
}
