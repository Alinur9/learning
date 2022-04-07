public class ReversANum {
    public static void main(String[] args) {
        int num = 45678;
        int reverse = 0;
        while (num != 0) {
           int remainder = num % 10;
            reverse = reverse * 10 + remainder;
            num = num / 10;
        }
        System.out.println(reverse);

        String name = "Tabassum";
        //int leng = name.length();
        String rev= "";
        for(int j = name.length()-1; j >= 0; j--){
            rev = rev + name.charAt(j);
    }
        System.out.println(rev);

    }

    }

