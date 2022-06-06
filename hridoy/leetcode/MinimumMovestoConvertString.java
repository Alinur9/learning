package leetcode.com.company;

public class MinimumMovestoConvertString {
    public int minimumMoves(String s) {
        int i=0;
        int step=0;
        while(i<s.length()){
            if(s.charAt(i)=='X'){
                i=i+3;
                step++;
            }
            else{
                i++;
            }
        }
        return step;


    }




    public static void main(String[] args) {
        String s = "OOOXOXOXOOXX";
        MinimumMovestoConvertString obj = new MinimumMovestoConvertString();
        System.out.println(obj.minimumMoves(s));
    }
}
