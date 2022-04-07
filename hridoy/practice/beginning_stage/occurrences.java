import java.util.Scanner;

public class occurrences {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("put the numbers : ");
        int scanele = scan.nextInt();
        int[] numbers = {1, 1, 1, 2, 2, 3, 3, 4, 5, 6,};
       // int searchele = 3;
        System.out.println(getNumbersOcc(numbers, scanele));
    }

    public static int getNumbersOcc(int[] numbers, int scanele) {
        int occ = 0;
        for (int i = 0; i < numbers.length; i++)
            if (scanele == numbers[i])
            occ++;
            return occ;
        }
    }

