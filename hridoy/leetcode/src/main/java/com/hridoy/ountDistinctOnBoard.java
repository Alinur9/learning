package com.hridoy;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class ountDistinctOnBoard {
    public int distinctIntegers(int n) {
        HashSet<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        set.add(n);
        queue.add(n);
        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int i = 1; i <= n; i++) {
                if ( x % i == 1 && !set.contains(i)) {
                        set.add(i);
                        queue.offer(i);
                }
            }
        }
        return set.size();

}

    public static void main(String[] args) {
        int n = 5;
        ountDistinctOnBoard obj = new ountDistinctOnBoard();
        System.out.println(obj.distinctIntegers(n));

    }
}
