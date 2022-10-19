package com.hridoy;

import java.util.LinkedList;

public class UnrechebleGraph {


    public long countPairs(int n, int[][] edges) {
        int pairs =0;
        LinkedList<Integer> list[];
        list = new LinkedList[n];
        for (int i=0;i< n;i++){
            list[i] = new LinkedList<>();
        }

        for (int j =0 ; j < edges.length;j++){
            list[edges[j][0]].addFirst(edges[j][1]);
            list[edges[j][1]].addFirst(edges[j][0]);
        }
        for (int k =0 ; k < list.length-1;k++){
            if ( list[k].size() < n-1){
                pairs += (n-1) - list[k].size();
            }
        }
        return pairs;

    }
    public static void main(String[] args) {
        int n =7;
        int [][] edges = {{0,2},{0,5},{2,4},{1,6},{5,4}};
        UnrechebleGraph obj = new UnrechebleGraph();
        System.out.println(obj.countPairs(n,edges));

    }
}
