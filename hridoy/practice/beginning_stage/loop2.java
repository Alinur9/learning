import java.util.Scanner;

public class loop2 {

    public static void main ( String[] args){
        int subjects;
        Scanner scan = new Scanner (System.in);
        System.out.println("how many subjects with result need to find");
        subjects = scan.nextInt();
        int total = 0;

        for ( int next = 0; next < subjects; next++) {
            int results;
            System.out.println("result of subject" + (next + 1));
            results = scan.nextInt();
            total += results;
        }
        //scan.close();
        System.out.println("total marks of result is  :" + total);
    }
}

