public class Contest_CheakEvery_RowColumn {
    public static boolean main(String[] args) {

        int[][] matrix = {{1, 2, 3},
                {2, 1, 3},
                {3, 1, 2}};
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != matrix[i+1][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}

