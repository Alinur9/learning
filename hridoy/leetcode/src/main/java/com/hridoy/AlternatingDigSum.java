package com.hridoy;

public class AlternatingDigSum {
    public int alternateDigitSum(int n) {
        String s = String.valueOf(n);
        int sum =0;
        for (int i=0;i<s.length();i++){
            int parseInt = Integer.parseInt(String.valueOf(s.charAt(i)));
            if(i%2 != 0){
                sum -= parseInt;
            }else {
                sum += parseInt;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int n = 111;
        AlternatingDigSum obj = new AlternatingDigSum();
        System.out.println(obj.alternateDigitSum(n));
    }
}
