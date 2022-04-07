import java.util.Scanner;

public class forloop {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("how many family members ages that you are gonna enter");
        int num;
        num = scan.nextInt();

        int[] ages = new int[num];

        for (int counter = 0; counter < num; counter++) {
            System.out.println("Enter the ages of family members" + (counter+ 1));
            ages[counter] = scan.nextInt();
        }
        scan.close();
        System.out.println("Your members ages are :");
        int Total = 0;


        for (int counter = 0; counter < num; counter++) {
            Total = Total + ages [counter];
            System.out.println(ages [counter]);


        }
        System.out.println("Total ages number is this "+ Total);


    }
}
