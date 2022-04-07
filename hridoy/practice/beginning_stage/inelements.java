import java.util.Scanner;

public class inelements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Number of rows in 2D array : ");
        int rows = sc.nextInt();

        System.err.println("Number of columns in 2D array : ");
        int columns = sc.nextInt();

        int element = 0;

        int [][] matrix = new int[rows][columns];

        System.out.println("Printing result");
        for(int[] arr : matrix){
            for(int i = 0; i < columns; i++){

                if(element > 1)
                    element = 0;

                arr[i] = element;
                element++;
            }
            for(int j : arr)
                System.out.print(j +" ");
            System.out.println();

        }
    }
}

