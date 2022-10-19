package com.hridoy;

public class CheckIfMatrixIsXMatrix {

    public boolean checkXMatrix(int[][] grid) {



        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if((i == j) || (i+j)==(grid.length-1)) {
                    if(grid[i][j] == 0)
                        return false;
                }
                else
                {
                    if(grid[i][j] !=0)
                        return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[][] a = {{2,0,0,1},{0,3,1,0},{0,5,2,0},{4,0,0,2}};

        CheckIfMatrixIsXMatrix obj = new CheckIfMatrixIsXMatrix();
        System.out.println(obj.checkXMatrix(a));
    }
}
