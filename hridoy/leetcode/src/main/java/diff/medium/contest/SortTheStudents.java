package diff.medium.contest;

import java.util.Arrays;

public class SortTheStudents {
    public int[][] sortTheStudents(int[][] score, int k) {
        int[][] sorted = new int[score.length][score[0].length];
        int max =0;
        int idx =0;
        for(int i=0;i<score.length;i++){
            for (int j =0; j < score.length;j++){
                if (score[j][k] > max ){
                    max = score[j][k];
                    idx = j;
                }
            }


            for (int j =0 ; j<score[0].length;j++){
                sorted[i][j] = score[idx][j];
            }
            score[idx][k] = 0;
            max =0;
        }

        return sorted;
    }

    public static void main(String[] args) {
        int[][] score = {{10,6,9,1},{7,5,11,2},{4,8,3,15}};
        int k =2;
        SortTheStudents obj = new SortTheStudents();
        System.out.println(Arrays.deepToString(obj.sortTheStudents(score, k)));
    }
}
