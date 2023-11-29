package diff.medium.contest;

import java.util.ArrayList;
import java.util.Arrays;

public class FindThePrefixCommonArrayOfTwoArrays {

    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] c = new int[A.length];
        int n =0;
        ArrayList<Integer> a = new ArrayList<>();
        while(n != A.length){
            int count =0;
          a.add(A[n]);
          for(int i=0; i < a.size();i++){
              if(a.contains(B[i])){
                  count++;
              }
          }
          c[n] = count;


            n++;
        }
return c;
    }

    public static void main(String[] args) {
        int[] a = {1,3,2,4};
        int[] b = {3,1,2,4};

        FindThePrefixCommonArrayOfTwoArrays obj = new FindThePrefixCommonArrayOfTwoArrays();
        System.out.println(Arrays.toString(obj.findThePrefixCommonArray(a, b)));
    }
}
