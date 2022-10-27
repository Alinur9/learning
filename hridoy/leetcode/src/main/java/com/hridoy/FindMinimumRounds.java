package com.hridoy;

import java.util.HashMap;

public class FindMinimumRounds {
    public int minimumRounds(int[] tasks) {

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i: tasks){
            if(map.containsKey(i)) map.put(i, map.get(i) +1);
            else map.put(i,1);
        }

        int count = 0;
        for(int freq: map.values()){
            if(freq>1){
                count += freq/3;
                if(freq%3 !=0)
                    count++;
            }
            else  return -1;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] tasks = {2,2,3,3,2,4,4,4,4,4};
        FindMinimumRounds obj = new FindMinimumRounds();
        System.out.println(obj.minimumRounds(tasks));
    }
}
