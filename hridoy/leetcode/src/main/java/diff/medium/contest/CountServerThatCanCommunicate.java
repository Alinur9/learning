package diff.medium.contest;

import java.util.HashMap;

public class CountServerThatCanCommunicate {
    public int countServers(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        if (row == 1 && col == 1)
            return 0;
        int [] rowArray = new int [row];
        int [] colArray = new int [col];
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (grid[i][j] == 1) {// server present in that row and col
                    rowArray[i] += 1;
                    colArray[j] += 1;
                }
            }
        }
        int connectedServers = 0;
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (grid[i][j] == 1 && (rowArray[i] > 1 || colArray[j] > 1))
                    connectedServers += 1;
            }
        }
        return connectedServers;
    }

    public static void main(String[] args) {

        int[][] grid = {{0,0,0,0},{1,1,1,1},{0,0,0,1},{0,0,1,1},{0,0,0,1}};
        CountServerThatCanCommunicate obj = new CountServerThatCanCommunicate();
        System.out.println(obj.countServers(grid));

    }
}
