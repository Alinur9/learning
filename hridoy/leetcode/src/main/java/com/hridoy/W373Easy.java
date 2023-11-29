package com.hridoy;

public class W373Easy {
    public boolean areSimilar(int[][] mat, int k) {

        int m = mat.length;
        int n = mat[0].length;

        int[][] original = new int[m][n];
        for (int i = 0; i < m; i++) {
            System.arraycopy(mat[i], 0, original[i], 0, n);
        }

        for (int i = 0; i < m; i++) {
            if (i % 2 == 1) {

                cyclicRightShift(mat[i], k);
            } else {
                cyclicLeftShift(mat[i], k);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != original[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void cyclicRightShift(int[] row, int k) {
        int n = row.length;
        k = k % n;

        reverse(row, 0, n - 1);
        reverse(row, 0, k - 1);
        reverse(row, k, n - 1);
    }

    private static void cyclicLeftShift(int[] row, int k) {
        int n = row.length;
        k = k % n;

        reverse(row, 0, k - 1);
        reverse(row, k, n - 1);
        reverse(row, 0, n - 1);
    }

    private static void reverse(int[] row, int start, int end) {
        while (start < end) {
            int temp = row[start];
            row[start] = row[end];
            row[end] = temp;
            start++;
            end--;
        }
    }


    public static void main(String[] args) {
        W373Easy obj = new W373Easy();
        int[] [] mat = {{1,2}};
        int k = 1;

        System.out.println(obj.areSimilar(mat,k));

    }
}
