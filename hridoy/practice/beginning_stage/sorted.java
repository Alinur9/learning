public class sorted {
    public static void main(String[] args) {
        int[] array1 = {8, 3, 4, 5, 10,6};

        for (int i1 = 1; i1 < array1.length; i1++) {

            for ( int i2 = 0; i2 < i1 ; i2++){

                if ( array1[i1] < array1[i2]){
                    int t = array1[i1];
                    array1[i1] = array1[i2];
                    array1[i2]= t;
                }

            }
            for (int a : array1){
                System.out.print(a+ ", ");
            }
            System.out.println();
        }
    }
}