package leetcode.com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class InterSectionOfMulOfArrays {

    public List<Integer> intersection(int[][] nums) {


        HashSet<Integer> hp1 = new HashSet<>();
        for (int j = 0 ; j < nums[0].length;j++){
            hp1.add(nums[0][j]);
        }
        for (int i = 1 ; i < nums.length;i++){
            HashSet<Integer> hp2 = new HashSet<>();
            for(int j =0; j < nums[i].length; j++){
                hp2.add(nums[i][j]);
            }
            hp1.retainAll(hp2);
        }
        List<Integer> arr = new ArrayList<>(hp1);
        Collections.sort(arr);
        return arr;

    }
    public static void main(String[] args) {

        int[][] nums = {{1,2,3},{4,5,6}};
        InterSectionOfMulOfArrays obj = new InterSectionOfMulOfArrays();
        System.out.println(obj.intersection(nums));

    }
}
