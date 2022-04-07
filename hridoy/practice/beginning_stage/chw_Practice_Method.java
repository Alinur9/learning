public class chw_Practice_Method {
    static void pattern1(int n){
        for (int i =1; i <= n ; i++){
            for (int j =n ;j>=i;j-- ){
                System.out.print("*");
            }
            System.out.println("");
        }

    }
    static int fibo(int n){
        int a = 0;
        int b = 1;
        int c = 0;
        if ( n == 1 || n== 2){
            return -1;
        }else {
            for ( int i = 3 ; i <= n ; i++) {//2/3/4/5
                c = a +b;//1/2/3/5/8
                a = b;//1/1/2/3/5
                b = c ;//1/2/3/5/8

            }
        }
        return c;

    }
    static int fibRec(int n) {
        if (n== 1 || n == 2) {
            return -1;
        } else {
            return fibRec(n- 1) + fibRec(n- 2);
        }
    }

    public static void main(String[] args) {
        int x =5;
        pattern1(x);
        System.out.println("Fibonacci number is " + fibo(x));
        int result = fibRec(x);
        System.out.println("Recursion of fibo is " + result);


    }
}
