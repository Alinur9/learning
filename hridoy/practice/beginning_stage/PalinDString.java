public class PalinDString {
    public static void main(String[] args){
        //Ex; mom , cooc
        String org= "race car";
        org = org.replace(" ", "");
        String reverse = "";
        for(int i = org.length()-1; i>=0;i--) {
            reverse += org.charAt(i);
            System.out.println(reverse);
        }
        boolean palindrome = true;
        for(int i=0;i<org.length();i++){
            if(org.charAt(i) != reverse.charAt(i)){
                palindrome = false;
            }
        }
        if(palindrome){
            System.out.println("PALINDROME");
        }
        else {
            System.out.println("NOT PALINDROME");
        }

    }
}
