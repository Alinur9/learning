package diff.medium.contest;

public class StrictlyPalindromicNumber {
    public boolean isStrictlyPalindromic(int n) {

        int rev =0;
        int n1 = n;
        String s = "" ;
        boolean flag = true;

        for (int i =2; i < n-2;i++){
            while (n1 > 0){
                rev = rev * i + n1 % i ;

                s+= String.valueOf(rev);
                n1 = n1 / i;
            }
            int j = s.length()-1;

            for (int k = 0; k < s.length();k++,j--){
                if (s.charAt(k) != s.charAt(j)){
                    return false;
                }

            }
            n1 = n;
            s = "";


        }
        return true;

    }

    public static void main(String[] args) {

        int n = 9;
        StrictlyPalindromicNumber obj = new StrictlyPalindromicNumber();
        System.out.println(obj.isStrictlyPalindromic(n));

    }
}
