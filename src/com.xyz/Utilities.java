package com.xyz;
public class Utilities {
    public static void main(String[] args) {
        testTextBetweenDelimiter();
    }
    private  static void testTextBetweenDelimiter(){
        String output=null;
        output= textBetweenDelimiter("1997ISMAIL.HOSEN@gmail.com","@",".");
        if(output.equals("gmail")){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }
        output=textBetweenDelimiter("1997ISMAIL.HOSEN@gmail.com","@","@");
        if(output==null){
            // happy case
            System.out.println("Passed");
        }else{
            // Failure case
            System.out.println("failed");
        }
        output=textBetweenDelimiter("1997ISMAIL.HOSEN@@gmail.com","@","@");
        if(output.equals("")){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }
        output=textBetweenDelimiter("1997ISMAIL.HOSEN@@gmail.com",null,"@");
        if(output==null){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }
    }
    //It will extract text between two given delimiter.
    //If any delimiter isn't present then it will return null.
    //If both delimiter in consecutive sequence then it will return empty String.
    //if any of the three String is null then it will return null
    public static String textBetweenDelimiter(String givenText,String firstDelimiter,String secondDelimiter){
        String output=null;
        if(givenText==null || firstDelimiter==null || secondDelimiter==null){
            return  output;
        }
        int startingDelimiterPosition=givenText.indexOf(firstDelimiter);
        int secondDelimiterPosition=givenText.indexOf(secondDelimiter, startingDelimiterPosition+firstDelimiter.length());
        if(startingDelimiterPosition>-1 && secondDelimiterPosition >-1){
            output=givenText.substring(startingDelimiterPosition+firstDelimiter.length(),secondDelimiterPosition);
        }
        return output;
    }
}
