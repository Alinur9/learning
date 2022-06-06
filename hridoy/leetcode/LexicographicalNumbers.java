package leetcode.com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        int [] n1 = new int[n];
        String[] s = new String[n1.length];
        for (int i =0; i < n ; i++){
            n1[i] = i+1;

            s[i] = String.valueOf(n1[i]);
        }
        Arrays.sort(s);


        for (int j =0 ; j < n; j++){
            list.add(Integer.parseInt(s[j]));
        }
        return list;



    }

    public static void main(String[] args) {
        int n = 13;
        LexicographicalNumbers obj = new LexicographicalNumbers();
        System.out.println(obj.lexicalOrder(n));

    }
}
