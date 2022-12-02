package diff.medium.contest;

import java.util.Arrays;

public class DiffBetwOnesnZero {
    public int[][] onesMinusZeros(int[][] grid) {
    int m = grid.length;;
    int n = grid[0].length;
    int [][] diff = new int[m][n];

        for (int i =0; i < grid.length;i++){
        for(int j = 0; j < grid[i].length;j++){
            diff[i][j] = checkDiff(grid,i,j);
        }



    }
        return diff;
}

    public int checkDiff(int[][] diff,int idx,int col){
        int onesRow = 0;
        int zerosRow = 0;
        int onesCol = 0;
        int zerosCol = 0;
        for (int i = idx ; i < diff.length;i++){
            for(int j = 0; j < diff[i].length;j++){
                if (diff[i][j] == 1){
                    onesRow++;
                }else {
                    zerosRow++;
                }
            }
            for (int  k = 0; k < diff.length;k++){
                if (diff[k][col] == 1){
                    onesCol++;
                }else {
                    zerosCol++;
                }
            }
            return onesRow+onesCol - zerosRow - zerosCol;
        }
        return 0;

    }




    public static void main(String[] args) {

        int[][] grid = {{1,1,1},{1,1,1}};
        DiffBetwOnesnZero obj = new DiffBetwOnesnZero();
        System.out.println(Arrays.deepToString(obj.onesMinusZeros(grid)));

    }
}
