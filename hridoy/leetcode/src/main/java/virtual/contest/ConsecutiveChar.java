package virtual.contest;

public class ConsecutiveChar {
    public int maxPower(String s) {
        int max =0;
        int count =1;

        for (int i =0; i < s.length();i++){
            for (int j = i+1; j < s.length();j++){
                if (s.charAt(i) == s.charAt(j)){
                    count++;
                }else
                break;
            }
            max = Math.max(max,count);
            count = 1;
        }
        return max;
    }

    public static void main(String[] args) {

        String s =  "abbcccddddeeeeedcba";

        ConsecutiveChar obj = new ConsecutiveChar();
        System.out.println(obj.maxPower(s));

    }
}
