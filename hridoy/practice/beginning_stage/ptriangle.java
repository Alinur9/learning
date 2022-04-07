public class ptriangle {
    public static void main(String[] args) {


        for (int i = 1; i <= 4; i++) {
            for (int j = 3; j >= i; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <=i; k++) {
                System.out.print("*");
            }
            for ( int l = 1 ; l<= 4; l ++){
                System.out.print(" ");
            }
            for (int m = 1; m<=i;m++){
                System.out.print("*");
            }
            System.out.println();
            }
        for (int n = 1 ; n<=4; n++){
            for (int o =1 ; o<=n;o++){
                System.out.print(" ");
            }
            for (int p = 3;p>=n;p--){
                System.out.print("*");
            }
            for (int q=1; q<=4;q++){
                System.out.print(" ");
            }
            for (int r = 3 ; r>=n;r--){
                System.out.print("*");
            }
            System.out.println();
        }
        }

    }
