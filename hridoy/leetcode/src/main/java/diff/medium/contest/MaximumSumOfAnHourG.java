package diff.medium.contest;

public class MaximumSumOfAnHourG {
    public int maxSum(int[][] grid) {
        int res = 0;
        int sum =0;


      int pointer = 0;
        int rowMid = 1;
        int count = 0;
        boolean flag = true;
            for (int i = 0; i < grid.length-2;i++){
            for (int j =0; j< grid[i].length ;j++){
                    if (count < 4){
                            sum+= grid[i][j];

                    if (flag) {
                             sum += grid[i + 1][rowMid];
                             flag= false;
                        }
                        sum += grid[i + 2][j];

                             count++;
                    if (count == 3){
                            flag= true;
                            j = pointer;
                            pointer++;
                            count =0;
                            rowMid++;
                            res = Math.max(res,sum);
                            sum = 0;
                        }
                    }
                }
                            flag = true;
                            sum = 0;
                            rowMid = 1;
                            pointer =0;
                            count =0;
        }
            return res;
    }

    public static void main(String[] args) {
        int[][] grid = {{6,2,1,3},{4,2,1,5},{9,2,8,7},{4,1,2,9}};

        MaximumSumOfAnHourG obj = new MaximumSumOfAnHourG();
        System.out.println(obj.maxSum(grid));
    }
}
