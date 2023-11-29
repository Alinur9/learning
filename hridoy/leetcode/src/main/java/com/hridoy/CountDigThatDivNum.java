package com.hridoy;

public class CountDigThatDivNum {
    public int countDigits(int num) {
        int tempNum = num;
        int count =0;
        int rev =0;
        while(num !=0){
            int remainder = num%10;
            rev = rev*10+remainder;
            num = num/10;

            if (tempNum % remainder == 0){
                count++;
            }

        }

            return count;
    }


    public static void main(String[] args) {
        int num = 7;
        CountDigThatDivNum obj = new CountDigThatDivNum();
        System.out.println(obj.countDigits(num));
    }
}
