public class MovesToConvertString {
    public int minimumMoves(String s){
        int count = 0;
        for (int i = 0; i < s.length();i++){
            if (s.charAt(i)!= 'O'){
                count ++;
                i+=2;
            }
        }


        return count;

    }

    public static void main(String[] args) {
        String s = "XXOX";

        MovesToConvertString c = new MovesToConvertString();
       int x= c.minimumMoves(s);
        System.out.println(x);
    }
}
