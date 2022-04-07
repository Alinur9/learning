import java.util.Scanner;

public class pattern {
    public static void main(String[] args) {
        int number;
        Scanner scan = new Scanner(System.in);
        System.out.println("How many Star would you like to have :");
        number = scan.nextInt();

        for (int i = 1; i <= number; i++) {
            for (int j = 0; j < i; j++) {

                System.out.print("*");
            }
            System.out.println();
        }
            for (int i = number - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {

                    System.out.print("*");
                }
                System.out.println();


            }
        }
    }