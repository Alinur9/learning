public class Fibonacci_Series {
    static int fibonacci_Recursion(int n){
        int fbnc=1;
        for (int i = 0 ; i<= n ; i++) {
            fbnc +=i ;
        }
        return fbnc;

    }
    public static void main(String[] args) {
        int x = 10;//55
        System.out.println("Fibonacci number is : " + fibonacci_Recursion(x));

    }

}
