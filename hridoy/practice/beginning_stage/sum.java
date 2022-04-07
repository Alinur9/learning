import java.util.Scanner;

public class sum {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = -1;
        int Total = 0;

        while (number < 1) {
            System.out.println("Enter a NonZero positive number : ");
            number = scan.nextInt();
        }
        for (int num1 = 1; num1 <= number; num1++) {
            Total = Total + num1;
        }
        System.out.println(" The sum from 1 to " + number + " is " + Total);
    }
}

