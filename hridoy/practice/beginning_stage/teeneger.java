import java.util.Scanner;

public class teeneger {
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        System.out.print("Enter your age please: ");
        int n = Sc.nextInt();

        if (n >= 31 && n <= 60) {
            System.out.println("old");

        } else if (n >= 20 && n < 31) {
            System.out.println("adult");

        } else if (n >= 13 && n < 20) {
            System.out.println("Teenage");

       } else if (n >= 1 && n < 13) {
            System.out.println("Kids");
        }else {
            System.out.println("you are alien ");
    }
    }


        }

