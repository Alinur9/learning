public class hoursclock {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {

                System.out.print(" ");
            }
            for (int k = 5; k >= i; k--) {
                System.out.print("*");
            }
            for ( int l = 4; l>=i;l--){
                System.out.print("*");
            }
            System.out.println();
        }
        for (int m = 1;m <= 5; m++){
            for ( int n = 4 ; n >= m ; n--){
                System.out.print(" ");
            }
            for ( int o = 0; o <= m ; o++){
                System.out.print("*");
            }
            for (int p = 1 ; p<=m;p++){
                System.out.print("*");
            }
            System.out.println();
        }
        for ( int q = 1 ; q <=3 ; q++){
            for (int r = 1 ; r <=q;r++){
                System.out.print(" ");
            }
            for (int s = 3 ; s >= q;s--){
                System.out.print("*");
            }
            for (int t = 2; t>=q;t--){
                System.out.print("*");
            }
            System.out.println();
        }
        for (int u = 1 ; u<= 3 ; u++){
            for ( int v = 2 ; v>=u;v--){
                System.out.print(" ");
            }
            for (int w = 0 ; w<=u;w++){
                System.out.print("*");
            }
            for (int x =1 ; x<=u;x++){
                System.out.print("*");
            }

            System.out.println();
        }
    }

}