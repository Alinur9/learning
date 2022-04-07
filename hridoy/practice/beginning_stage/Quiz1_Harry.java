import java.util.Scanner;

public class Quiz1_Harry{
    public static void main(String[] args) {
       int subj = 5;

        System.out.println("We will get percentage of 5 subjects ");
        Scanner sc = new Scanner(System.in);
        System.out.println("1st subject number is ");
        int a = sc.nextInt();
        System.out.println("2nd subject number is ");
        int b = sc.nextInt();
        System.out.println("3rd subject number is ");
        int c = sc.nextInt();
        System.out.println("4th subject number is ");
        int d = sc.nextInt();
        System.out.println("5th subject number is ");
        int e = sc.nextInt();
        float f = ((a + b + c + d + e) / 500.0f)*100;
        System.out.println("total percentage of 5 subject is " + f);


       /* System.out.println("search the kilometers for get the miles the way of road ");
        Scanner sc = new Scanner(System.in);
        double km1 = sc.nextFloat();
        double miles = 0.621371;
        double result = km1*miles;
        System.out.println("the total miles of the road for go to tabassum home from to college  " + result );*/
      /*  int a = 10 ;
        int b = 20;
        int c = (a - b)/2; // a-b/2= 0
        System.out.println(c);*/
      /* int b =1;
        int a =5;
        int c = 4;
        int d = (b*b - 4*a*c)/(2*a);
        System.out.println(d); // ans = -199*/
        /*int v = 4;
        int u = 2;
        int w = v*v - u*u;
        System.out.println(v);
        int a = 10;
        int b = 3;
        int d = 10;
        int c = a*b - d;
        System.out.println(c);*/
       /* int y = 7 ;
        int x = ++y * 8;
        System.out.println(x);
        char a = 'b';
        a--;
        System.out.println(a);*/

          }
    }

