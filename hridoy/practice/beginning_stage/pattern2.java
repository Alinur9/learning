import java.util.Scanner;

public class pattern2 {
    public static void main (String[] args){
        int num;
        Scanner sc = new Scanner(System.in);
        System.out.println("How many star would you like to have :");
        num = sc.nextInt();

        for( int i = 1 ; i <= num ; i++){
            for(int j = num ; j >= i ; j--){

                System.out.print("*");
            }
            System.out.println();
        }
    }
}
