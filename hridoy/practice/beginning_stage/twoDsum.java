public class twoDsum {
    public static void main(String[] args) {
        int[][] numbers = {{1, 2, 3, 4},
                {5, 6, 7, 8,},
                {9, 10, 11, 12, 13},
                {10,20,-30,40,50}};

       int [] arr = new int [numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            int sum = 0;

            for (int j = 0; j < numbers[i].length; j++) {
                sum = sum + numbers[i][j];
            }
            arr[i]=sum;
            System.out.println(arr[i]);
        }
    }

}




