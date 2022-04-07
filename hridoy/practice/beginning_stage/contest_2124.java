public class contest_2124 {
    public  boolean checkString(String s){
        int length = s.length();
        for (int i = 0; i < length -1; i++){
            if(s.charAt(i) == 'b' && s.charAt(i+1) == 'a') return false;
        }
        return true;
    }


    public static void main(String[] args) {
String s = "abab";
contest_2124 c = new contest_2124();
c.checkString(s);
        System.out.println();
            }
}