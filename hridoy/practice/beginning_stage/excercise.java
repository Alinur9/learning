import java.util.Arrays;
import java.util.Scanner;
class excercise {
    public static void main(String [] args){
    Scanner input = new Scanner(System.in);

    System.out.print("how many elements? (max is 25): ");
    int n = input.nextInt();

    while (n > 25 || n<=0){
        System.out.println("invalid number, try again: ");
        n = input.nextInt();
    }
    int[] numbers = new int[n];
    //fillArrayOfIntegers
        //PrintArrayOfIntegers

        fillArrayOfIntegers(numbers);
       PrintArrayOfIntegers(numbers);
        System.out.println(Arrays.toString(numbers));
}

    private static void PrintArrayOfIntegers(int[] numbers) {
        System.out.print("the elements are: ");
        System.out.println(Arrays.toString(numbers));

    }
    private static void fillArrayOfIntegers(int[] numbers) {
        Scanner input = new Scanner(System.in);
        for ( int i = 0 ; i < numbers.length; i++){
            numbers[i] = input.nextInt();
        }
    }
}