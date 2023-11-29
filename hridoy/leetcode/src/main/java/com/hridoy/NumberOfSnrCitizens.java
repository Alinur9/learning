package com.hridoy;

public class NumberOfSnrCitizens {

    public int countSeniors(String[] details) {
        int years60 =0;
        for (int i=0;i<details.length;i++){
            int age = Integer.parseInt( String.valueOf(details[i].charAt(11)) + String.valueOf(details[i].charAt(12)));
            if(age >60){
                years60++;
            }
        }
return years60;
    }
    public static void main(String[] args) {
        String[] details ={"7868190130M7522","5303914400F9211","9273338290F4010"};
        NumberOfSnrCitizens obj = new NumberOfSnrCitizens();
        System.out.println(obj.countSeniors(details));

    }
}
