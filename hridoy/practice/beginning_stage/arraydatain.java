
import java.util.Scanner;

public class arraydatain {
    public static void main (String[] args){

        Scanner scan = new Scanner(System.in);
        int row = scan.nextInt();

        System.out.println(" Enter the number of columns ");

        int col = scan.nextInt();

        //defined the 2D array to hold data

        int[][] Arr= new int [row][col];

        //enter data

        enterData(scan,Arr,row,col);
        //print data
        printData(Arr,row,col);


    }
    public static void enterData(Scanner scan ,int[][] Arr,int row,int col){
        System.out.println(" Enter Arr data ");
        for (int i =0; i < row;i++){
            for (int j =0; j<col;j++){
                Arr[i][j]= scan.nextInt();
            }
        }
    }

    public static void printData(int[][]Arr,int row,int col){
        System.out.println(" your data is ");
        for(int i =0; i < row; i++){
            for(int j =0; j < col; j++){
                System.out.print(Arr[i][j]+" ");
            }
            System.out.println();
        }

    }
}
