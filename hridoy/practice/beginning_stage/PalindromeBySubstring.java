public class PalindromeBySubstring {
    public boolean isPalindrome(String str){
        int size = str.length();
        if ( size == 0 || size == 1){
            return true ;
        }
        String starInd = str.substring(0,1);
        String endInd = str.substring(size-1);
        if ( starInd.equals(endInd)){
            return isPalindrome( str.substring(1,size-1));
        }
        return false;

    }
    public static void main (String [] args ){
        String[] words ={"eye","peep","pjkp",""};
        PalindromeBySubstring c = new PalindromeBySubstring();
        for ( int i = 0 ; i < words.length;i++){
            if(c.isPalindrome(words[i])){
                System.out.println("is palindrome " + words[i]);
            }
            else {
                System.out.println(" is not palindrome " + words[i]);
            }
        }

    }
}
