import java.util.Scanner;

public class Chw_19_practice_que {
    public static void main(String[] args) {
      /*  double tax = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println(" Employee total income in this month is ");
        float income = sc.nextFloat();
        if ( income >= 250000.0f && income <= 500000.0f){
            tax  = tax + 0.05* (income - 250000.0f);
            System.out.println(" you have to pay for government " + tax + " Money  Tax ");
        }
        else if ( income >= 500000.0f && income <= 1000000.0f){
            tax = tax + 0.05* ( 500000.0f - 250000.0f);
            tax = tax+ 0.20*( income  - 500000.0f);
            System.out.println(" you have to pay for government " + tax + " Money  Tax ");
        }
        else {
            System.out.println(" please work hard for government ");
        }
        */
        /*int day = 4;
        switch (day){
            case 1:
                System.out.println("saturday");
            break;
            case 2:
                System.out.println("sunday");
                break;
            case 3:
                System.out.println("monday");
                break;
            case 4:
                System.out.println("tuesday");
                break;


            default:
                throw new IllegalStateException("Unexpected value: " + 1);
        }
        */
       /* Scanner sc = new Scanner(System.in);
        int yearOfDays = sc.nextInt();

        if (yearOfDays == 366){
            System.out.println(" yes , is it leap year  ");
        }
        else System.out.println("is not a leap year");
        */
       /* byte n = 5;
        for (byte i = n ; i > 0; i--){
            System.out.println(i);*/
      /*  byte n = 5;
        do {
            System.out.println(n);
            n++;
        }while (n == 4);*/
        /*int number = 10;
        for (int i = 0 ; i < number;i++){
            if ( i % 2 == 0)// 2*i+1

                System.out.println(i);

            }*/
        for ( int i =4 ; i > 0 ; i --){
            for (int j = 0; j < i ; j++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }

       int sum = 0 ;
        int n = 5;
        int i = 0;
        while (i < n ){
            sum = sum + (2*i);
            i++;
        }
        System.out.println("sum of even number is :" + sum);

        }
        }
