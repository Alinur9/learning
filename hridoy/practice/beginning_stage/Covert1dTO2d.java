

public class Covert1dTO2d {
    public  int [][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m*n) return new int[0][0];
        int[][] res = new int[m][n];
        int next = 0 ;
        for ( int i =0; i < m ; i++){
            for ( int j = 0;j< n;j++){
                res[i][j] = original[next++];
            }
        }
        return res;


    }

    public static void main(String[] args) {
        int[] org = {1,2,3,4};
        int m = 2;
        int n = 2;
      Covert1dTO2d c = new Covert1dTO2d();
     int[][] x= c.construct2DArray(org, m, n );
     for (int i = 0 ; i < x.length;i++){
         for(int j =0; j < x[i].length;j++){
             System.out.print(x[i][j]);
         }
         System.out.println(" ");
     }
      }
    }
