import java.util.Random;
import java.util.Scanner;

 class Practice_Guess_game {

    // @TODO:  create properties randomNumber, noOfGuess
    private final int computerValue;
    private int noOfGuess;

    // @TODO:  create constructor
    //@TODO: generate random number in constructor

    public Practice_Guess_game() {
        Random ran = new Random();
        computerValue = ran.nextInt(6) + 1;
    }


    //@TODO: take number input from user: use scanner
    public void playTheGame() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome To The Guessing Contest Game");
        int userValue = -1;
        while (computerValue != userValue) {
            userValue = sc.nextInt();
            if (computerValue != userValue && userValue > -1) {
                System.out.println("Please try again !\t Enter Your Value");
            }

            sc.nextLine();
            if (userValue == -1) {
                System.out.println("Thanks For Your Participate , See You Again");
                break;
            }

            noOfGuess++;
            System.out.println("Attempt Number " + noOfGuess);

            System.out.println("Answer is " + (userValue == computerValue));
        }
        sc.close();
//        if (userValue > -1) {
//            System.out.println("Computer Value was " + computerValue);
//        }
        //@TODO: update guess count


        //@TODO: comare user input with property and print right or wrong

    }
}
