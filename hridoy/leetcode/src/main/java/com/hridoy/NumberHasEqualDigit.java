package com.hridoy;

public class NumberHasEqualDigit {
    public boolean digitCount(String num) {
        int count = 0;
        char[] ch = num.toCharArray();
        for (int i =0 ; i < ch.length;i++){
            for ( int j = 0 ; j < ch.length; j++){
                if (i == Character.getNumericValue(ch[j])){
                    count ++;
                }
            }
            int occur = Character.getNumericValue(ch[i]);
            if (count != occur){
                return  false;
            }
            count = 0;
        }
    return true;
    }
    public static void main(String[] args) {
        String num = "030";
        NumberHasEqualDigit obj = new NumberHasEqualDigit();
        System.out.println(obj.digitCount(num));
    }
}
