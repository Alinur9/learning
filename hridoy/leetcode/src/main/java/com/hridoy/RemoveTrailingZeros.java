package com.hridoy;

public class RemoveTrailingZeros {
    public String removeTrailingZeros(String num) {
        int count =0;
        int n = num.length();
        for(int i = num.length()-1;i >0;i--){
            if(Integer.parseInt(String.valueOf(num.charAt(i))) != 0){
                break;
            }
           count++;
        }
        String ans =num.substring(0,n-count);
        return  ans;
    }
    public static void main(String[] args) {
String nums = "123";
RemoveTrailingZeros obj = new RemoveTrailingZeros();
        System.out.println(obj.removeTrailingZeros(nums));
    }
}
