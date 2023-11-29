package com.hridoy;

public class MaximumValueOfAStringInAnArr {
    public int maximumValue(String[] strs) {

                int ans = 0;
                int p = 0;


                for (int i = 0; i < strs.length; i++) {
                    Boolean f = Character.isDigit(strs[i].charAt(0));
                    if(f){
                        p=strs[i].length();

                        if (p > ans) {
                            ans = p;
                        }
                    } else{
                        p = Integer.parseInt(strs[i]);
                        if (p > ans) {
                            ans = p;
                        }
                    }
                }
                return ans;

            }





//        int max = 0;
//        for (String str : strs) {
//            if (max < checkValue(str)) {
//                max = checkValue(str);
//            }
//        }
//        return  max;
//    }
//    public int checkValue(String value){
//        StringBuilder sb = new StringBuilder();
//        boolean stringFlag = false ;
//        int finalLength ;
//        char[] chars = value.toCharArray();
//        for(char c : chars){
//            if(Character.isDigit(c)){
//                sb.append(c);
//
//            }else {
//                stringFlag = true;
//            }
//        }
//
//        if (!stringFlag){
//           finalLength = Integer.parseInt(String.valueOf(sb));
//           return finalLength;
//        }
//        return value.length();
//    }


    public static void main(String[] args) {
        String[] strs = {"5232","yv","22","c","yawgs","928","4003","2"};
        MaximumValueOfAStringInAnArr obj = new MaximumValueOfAStringInAnArr();
        System.out.println(obj.maximumValue(strs));
    }
}
