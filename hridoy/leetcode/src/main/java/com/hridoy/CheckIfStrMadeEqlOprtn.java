package com.hridoy;

public class CheckIfStrMadeEqlOprtn {
    public boolean canBeEqual(String s1, String s2) {
int count =0;

        for(int i=0;i<4;i++){
            for(int j=2;j<4;j++){
                if(j-i == 2 && s1.charAt(i) == s2.charAt(j) && s2.charAt(i) == s1.charAt(j) ||
                        s1.charAt(i) == s2.charAt(i) && s1.charAt(j) == s2.charAt(j)&& j-i ==2 ){
                    count++;
                    if(count == 2 ){
                        return true;
                    }
                }
            }

        }
        return false;

    }
    public static void main(String[] args) {
String s1 ="zzon";
String s2 ="zozn";
CheckIfStrMadeEqlOprtn obj = new CheckIfStrMadeEqlOprtn();
        System.out.println(obj.canBeEqual(s1,s2));
    }
}
