package diff.medium.contest;

import java.math.BigInteger;
import java.util.Arrays;

public class FindDivOfString {
    public int[] divisibilityArray(String word, int m) {
        int n = word.length();
        int[] divisibility = new int[n];
        StringBuilder sb = new StringBuilder();
        BigInteger big = BigInteger.valueOf(0);
        for(int i=0;i<n;i++){

            sb.append(word.charAt(i));
            big = BigInteger.valueOf(Long.parseLong(sb.toString()));

            if(big.intValue() % m ==0){
                divisibility[i] =1;
            }else {
                divisibility[i] =0;
            }
        }

        return divisibility;
    }

    public static void main(String[] args) {
        String word = "529282143571";
        int m =4;
        FindDivOfString obj = new FindDivOfString();
        System.out.println(Arrays.toString(obj.divisibilityArray(word, m)));

    }
}
