public class chw_chp5 {
    public static void main(String[] args) {
       /* int multiplc_number = 5;
        for (int i = 1 ; i <= 10;i++){
           // System.out.println("5 x "+i+ " = " +multiplc_number * i);
            System.out.printf("%d x %d = %d \n" , multiplc_number , i , multiplc_number*i);
        }*/
        /*int n = 10;
        for ( int i = n ; i >= 1 ; i -- ){
            System.out.printf("%d x %d = %d \n", i , n , i*n);
        }*/
       // int sum = 0;
       /* int n = 5 ;
        int fact = 1;
        for (int i = 1 ; i <= 4 ; i++){
            fact *= i;
        }
        System.out.println(fact);*/
     /*   int n = 5;
        int fact = 1;
        int i = 1;
        while ( i <= n){
            fact*= i;
            i++;
        }
        System.out.println(fact);*/
       /* int n = 10;
        int i = 1;
        while (n >= i){

            for (int j = 0; j < n ; j++) {
                System.out.print("*");
            }
            n--;
            System.out.print("\n");
        }*/
        int n = 4;
        int sum = 0;
        for (int i = 1 ; i <= 10 ; i++){
            sum = sum + (n*i);
        }
        System.out.println(sum);
       /* int sum = 0;
        int n = 5;
        for (int i = 0 ; i < n ; i++){
            sum = sum + (2*i);
        }
        System.out.println(sum);*/
        int sum1 = 4;
        int sum2 =0;
        for (int j = 1 ; j <= sum1; j++){
            sum2 = sum2 +j;
        }
        System.out.println(sum2);
    }
}
