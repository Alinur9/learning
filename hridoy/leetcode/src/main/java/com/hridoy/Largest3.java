package com.hridoy;

public class Largest3 {

    public String largestGoodInteger(String num) {

        int max =0;
        String ans = "";
        String ans2= "000";
        String s ="";
        for(int i =0 ; i < num.length()-2;i++){
            if (num.charAt(i) == num.charAt(i+1) && num.charAt(i+1) == num.charAt(i+2)){
                 s = num.substring(i,i+3);
                int res = Integer.parseInt(s);
                max = Math.max(res,max);
            }
        }
        if (max == 0 && s.equals(ans2)){
            return ans2;
        }else if (max != 0) {
            ans = String.valueOf(max);
            return ans;
        }else return ans;

    }

    public static void main(String[] args) {

        String num = "4000333888999";
        Largest3 obj = new Largest3();
        System.out.println(obj.largestGoodInteger(num));
    }
}
