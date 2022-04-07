public class sumofarray {
    public static void main(String[] args) {
        int[][] num = {{7, 8, 8, 9}, {1, 3, 4, 5},{2,3}};
        int sum = 0;

        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num[i].length; j++) {

                sum = sum + num[i][j];
            }
        }
        System.out.println(" " + sum );
    }
}
