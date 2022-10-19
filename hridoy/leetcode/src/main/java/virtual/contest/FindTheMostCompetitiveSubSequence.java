package virtual.contest;

import java.util.Arrays;

public class FindTheMostCompetitiveSubSequence {
    public int[] mostCompetitive(int[] nums, int k) {

        int[] output = new int[k];
        int count =0;
        int mark =0 ;
        for (int i =0; i < nums.length; i++){
            output[count] = nums[i];
            for (int j =i+1; j < nums.length;j++){
                    output[count] = Math.min(output[count], nums[j]);
                    if (output[count] == nums[j]){
                        mark = j-1;
                }
            }
            count++;
            k--;
            i = mark;
            if (k == 0){
                break;
            }
        }

        return output;

    }
    public static void main(String[] args) {

        int [] num ={2,4,3,3,5,4,9,6};
        int k = 4;

        FindTheMostCompetitiveSubSequence obj = new FindTheMostCompetitiveSubSequence();
        System.out.println(Arrays.toString(obj.mostCompetitive(num, k)));
    }
}
