public class Utilities {
    public static void main(String[] args) {
        System.out.println(extractTextBetweenDelimiter("1997ismail.hosen@gmail.com","@","."));
    }
    public static String extractTextBetweenDelimiter(String givenText,String firstDelimiter,String secondDelimiter){
        int startingDelimiterPosition=givenText.indexOf(firstDelimiter);
        int secondDelimiterPosition=givenText.indexOf(secondDelimiter, startingDelimiterPosition+1);
        String output=givenText.substring(startingDelimiterPosition,secondDelimiterPosition);
        return output;
    }
}
