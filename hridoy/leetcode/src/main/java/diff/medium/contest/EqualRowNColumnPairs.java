package diff.medium.contest;

import java.util.HashMap;

public class EqualRowNColumnPairs {
    public int equalPairs(int[][] grid) {
        int pairs =0;
        String sb = "";
        HashMap<Integer,String> map = new HashMap<>();

        for (int i =0; i < grid.length;i++){
            for (int j =0; j < grid[i].length;j++){
                    sb +=  String.valueOf(grid[i][j]) + "," ;
                }
            map.put(i,sb);
            sb = "";
            }
        for (int i = 0;i < grid[0].length ; i++){
            for(int j =0; j < grid.length;j++){
                sb+= String.valueOf(grid[j][i]) + ",";
            }
            for (int k =0 ; k < map.size();k++){
                if(map.get(k).equals(sb)){
                    pairs++;
                }
            }
            sb= "";
        }


        return pairs;

    }

    public static void main(String[] args) {

        int [][] grid = {{11,1},{1,11}};

        EqualRowNColumnPairs obj = new EqualRowNColumnPairs();
        System.out.println(obj.equalPairs(grid));

    }
}
