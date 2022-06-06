package leetcode.com.company;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOF2DArraysWays2 {

    public List<Integer> intersection(int[][] nums) {
        int[] freq = new int[1001];

        for(int i=0; i<nums.length;i++)
        {
            for(int j=0; j<nums[i].length; j++)
            {
                freq[nums[i][j]]++;
            }
        }


        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<1001;i++)
        {
            if(freq[i]==nums.length) ans.add(i);
        }
        return ans;

    }

    public static void main(String[] args) {
        int[][] nums = {{3,1,2,4,5},{1,2,3,4},{3,4,5,6}};
        IntersectionOF2DArraysWays2 obj = new IntersectionOF2DArraysWays2();
        System.out.println(obj.intersection(nums));
    }
}
