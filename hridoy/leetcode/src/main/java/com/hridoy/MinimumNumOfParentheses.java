package com.hridoy;

public class MinimumNumOfParentheses {
    public int minimumCount(String s){

        int ans =0;
        int bal =0;
        for (int i =0 ; i < s.length();i++){
            bal += s.charAt(i) == '(' ? 1 : -1 ;
            if (bal == -1 ){
                bal += 1;
                ans += 1;
            }
        }
        return bal +ans;




    }

    public static void main(String[] args) {
        String paretheses = "()))))";
        MinimumNumOfParentheses obj = new MinimumNumOfParentheses();
        System.out.println(obj.minimumCount(paretheses));
    }
}
