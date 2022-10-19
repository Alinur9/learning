package com.hridoy;
public class StrongPasswordCheck {
    public boolean strongPasswordCheckerII(String password) {
        if (password.length() <8){
            return false;
        }
        char ch ;
        boolean capitalFlag = false;
        boolean lowerFlag = false;
        boolean numFlag = false;
        boolean adjecentFlag = true;
        boolean specialFlag = false;
        int count = password.length();
        for (int i =0; i<password.length();i++){
            ch = password.charAt(i);
              if (Character.isLowerCase(ch)){
                lowerFlag = true;
                count--;
            } else if (Character.isDigit(ch)) {
                numFlag = true;
                count--;

            } else if (Character.isUpperCase(ch)) {
                capitalFlag = true;
                count--;
            }

            if (i != password.length()-1 && ch  == password.charAt(i+1)){
                adjecentFlag = false;
            }
        }
        if (count != 0){
            specialFlag = true;
        }
        if (capitalFlag && lowerFlag && numFlag && specialFlag && adjecentFlag){
            return  true;
        }
        return false;

    }
        public static void main(String[] args) {

        String password = "aA!A!A!1";

        StrongPasswordCheck obj = new StrongPasswordCheck();
            System.out.println(obj.strongPasswordCheckerII(password));
            int i = 3;
            int j = -4;
            int sum = (i)-(j);
            System.out.println(sum);

    }
}
