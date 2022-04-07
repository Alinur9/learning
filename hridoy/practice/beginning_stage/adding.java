import java.util.Scanner;

public class adding {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("whats your name : ");
        String name = scan.next();

        System.out.println();

        System.out.println("whats your age : ");
        int age = scan.nextInt();

        System.out.println( );

        System.out.println("whats your hobby : ");
        String hobby = scan.next();
        hobby = hobby + scan.nextLine();

        System.out.println(" Thank you " + name + " age are " + age + " years old " );
        System.out.println("my hobby is " + hobby );

    }
}
