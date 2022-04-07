public class arrmnmx {
    public static void  main(String[] args){
        int[] numbers = {1,2,4,5,6,7,10,5,7,3,};

        int max = numbers[0];
        int min = numbers[0];

        for (int i =1; i < numbers.length;i++){
            max = (numbers[i] > max) ? numbers[i] : max ;
            min = (numbers[i] < min) ? numbers[i] : min ;

        }
        System.out.println(" max " + max + ", min " + min);
    }

}
