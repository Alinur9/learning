package com.hridoy;

public class DeleteGreatestValueInEachRow {
    public int deleteGreatestValue(int[][] grid) {
    int answer=0;
    int temp =0;
    int trackJ =0;
    int temp1 =0;

    for(int k =0;k<grid[0].length;k++) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] > temp && grid[i][j] != 0 ){
                    temp = grid[i][j];
                    trackJ = j;
                }
            }
            grid[i][trackJ]=0;
            if(temp>temp1){
                temp1 = temp;
            }
            temp =0;
        }
        answer+=temp1;
        temp1 =0;

    }


    return answer;
    }



    public static void main(String[] args) {
        int[][] grid = {{58,42,8,75,28},{35,21,13,21,72}};
        DeleteGreatestValueInEachRow obj = new DeleteGreatestValueInEachRow();
        System.out.println(obj.deleteGreatestValue(grid));
    }
}
