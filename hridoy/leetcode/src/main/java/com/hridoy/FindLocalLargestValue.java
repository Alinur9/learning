package com.hridoy;
import java.util.Arrays;
public class FindLocalLargestValue {
    public int[][] largestLocal(int[][] grid) {
        int n=grid.length;
        int[][]ans =new int[n-2][n-2];
        for(int i=0;i<n-2;i++){
            for(int j=0;j<n-2;j++){
                ans[i][j]=func(i,j,grid);
            }
        }
        return ans;
    }
    public int func(int st, int sec, int[][] grid){
        int maxElement = Integer.MIN_VALUE;
        for (int i = st; i <= 2+st; i++) {
            for (int j = sec; j <= 2+sec; j++) {
                if (grid[i][j] > maxElement) {
                    maxElement = grid[i][j];
                }
            }
        }
        return maxElement;
    }

    public static void main(String[] args) {
        int[][] grid = {{9,9,8,1},{5,6,2,6},{8,2,6,4},{6,2,2,2}};
        FindLocalLargestValue obj = new FindLocalLargestValue();
        System.out.println(Arrays.deepToString(obj.largestLocal(grid)));
    }
}
