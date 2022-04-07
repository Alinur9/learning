public class Check_if_Numbers_are_Ascending_in_a_sentence {
    public boolean numbersAreAscending (String s){
        int prev = -1;
        for (String num :  s.split(" ")) {     //Separate words from String
            if ('0' <= num.charAt(0) && num.charAt(0) <= '9') {     // True means word is any number
                int cur = Integer.parseInt(num);     // parse int from String
                if (prev < cur) prev = cur;     // update prev with cur for next comparision
                else return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        String s = "1 box has 3 blue 4 red 6 green and 12 yellow marbles";
        Check_if_Numbers_are_Ascending_in_a_sentence c = new  Check_if_Numbers_are_Ascending_in_a_sentence();
        c.numbersAreAscending(s);
        System.out.println(c.numbersAreAscending(s));


    }
}
