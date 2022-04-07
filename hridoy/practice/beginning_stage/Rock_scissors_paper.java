import java.util.Random;
import java.util.Scanner;

public class Rock_scissors_paper {
    public static void main(String[] args) {
        // Note : 1 = rock & 2 = scissor , & 3 = paper ,

        int ahsan_Point = 0;
        int computer_point = 0;
        byte tie_times = 0;

        Random ran = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.println(" welcome to Rock_Scissor_paper game \n we gonna play total 5 rounds \n you can start to attack your enemies Now !! \n between 1 to 3 numbers");

        for (int i =0 ; i < 5 ; i++) {

            byte ahsan = sc.nextByte();
            if (ahsan > 3 || ahsan < 1) throw new IllegalCallerException("unexpected value ");

            System.out.println("Ahsan attack \t " + ahsan);

            int computer = ran.nextInt(3) + 1;
            System.out.println(" computer attack \t " + computer);
            if (ahsan == 2 && computer == 1 || ahsan == 1 && computer == 3 || ahsan == 3 && computer == 2) {
                computer_point++;
                System.out.println("computer win  total " + computer_point + " times ");

            } else if (ahsan == 1 && computer == 2 || ahsan == 3 && computer == 1 || ahsan == 2 && computer == 3) {
                ahsan_Point++;
                System.out.println("Ahsan win  total " + ahsan_Point + " times ");

            } else if (ahsan == computer) {
                tie_times++;
                System.out.println("Tie Game , try again !");
            }
        }

            if (ahsan_Point > computer_point){
                int final_Result = ahsan_Point - computer_point;
                System.out.println("\t Total tie time is : " + tie_times + "\t times ");
                System.out.println("computer gets total :\t " + computer_point + "\t points ");
                System.out.println("Ahsan gets total :\t " + ahsan_Point + " \t points ");
                System.out.println("congrats Ahsan  \n \t you win by \t"  +  final_Result  +  "\t point");
            }
            else if (ahsan_Point < computer_point){
                int final_Result1 = computer_point - ahsan_Point;
                System.out.println("\t Total tie time is : " + tie_times + "\t times ");
                System.out.println("Ahsan gets total :\t " + ahsan_Point + "\t points ");
                System.out.println("Computer gets total :\t " + computer_point + " \t points ");
                System.out.println("congrats computer \n \t you win by \t"  + final_Result1 +  "\t point");
            }
            else {
                System.out.println("Ahsan gets total :\t " + ahsan_Point + "\t points ");
                System.out.println("Computer gets total :\t " + computer_point + " \t points ");
                System.out.println("thank you its a tie game \n Game Over ");
            }

            }


}

