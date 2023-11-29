package com.hridoy;

import java.util.ArrayList;
import java.util.List;

public class PointsThatIntersectWithCars {
    public int numberOfPoints(List<List<Integer>> nums) {
        int startPoint;
        int endPoint;
       List<Integer> list = new ArrayList<>();
        for(int i =0; i<nums.size();i++){
            startPoint = nums.get(i).get(0);
            endPoint = nums.get(i).get(1);
            for (int j = startPoint ;j <= endPoint ;j++) {
                if (!list.contains(j)) {
                    list.add(j);
                }
            }

        }
        return list.size();
    }
    public static void main(String[] args) {
        List<List<Integer>> nums = new ArrayList<>();
        List<Integer> subNums;
        subNums = new ArrayList<>();
        subNums.add(3);
        subNums.add(6);
        nums.add(0,subNums);
        subNums = new ArrayList<>();
        subNums.add(1);
        subNums.add(5);
        nums.add(1,subNums);
        subNums = new ArrayList<>();
        subNums.add(4);
        subNums.add(7);
        nums.add(2,subNums);

        PointsThatIntersectWithCars obj = new PointsThatIntersectWithCars();
        System.out.println(obj.numberOfPoints(nums));
    }
}
