package diff.medium.contest;

public class ConstructSmallestNumFromDIString {
    public String smallestNumber(String s) {
        StringBuilder res = new StringBuilder(), stack = new StringBuilder();
        for (int i = 0; i <= s.length(); i++) {
            stack.append((char)('1' + i));
            if (i == s.length() || s.charAt(i) == 'I') {
                res.append(stack.reverse());
                stack = new StringBuilder();
            }
        }
        return res.toString();
        }
    public static void main(String[] args) {
        String pattern = "IIIDIDDD";
        ConstructSmallestNumFromDIString obj = new ConstructSmallestNumFromDIString();
        System.out.println(obj.smallestNumber(pattern));
    }
}
