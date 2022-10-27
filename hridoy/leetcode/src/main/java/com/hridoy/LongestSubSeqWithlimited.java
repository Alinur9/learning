package com.hridoy;

import java.util.Arrays;

public class LongestSubSeqWithlimited {
    public int[] answerQueries(int[] nums, int[] queries) {
        int[] ans = new int[queries.length];

        int sum = 0;
        int sub =0;
        Arrays.sort(nums);

        for (int i =0; i < queries.length;i++){
            for (int j =0; j < nums.length;j++){
                if (nums[j] + sum <= queries[i]){
                    sub ++;
                    sum += nums[j];
                }

            }

            ans[i] = sub;
            sub=0;
            sum =0;


        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {469781,45635,628818,324948,343772,713803,452081};

        int[] queries = {816646,929491};
        LongestSubSeqWithlimited obj = new LongestSubSeqWithlimited();
        System.out.println(Arrays.toString(obj.answerQueries(nums, queries)));

        }

    }


