import java.util.Arrays;

public class retarr {
    static   int[] numbers(int[] a) {
        int sum=0;
        for (int i = 0; i < 1; i++)
            for (int j = 0; j < a.length;j++)
        sum += a[j];
        return new int[]{sum};

    }


    public static void main(String[] args) {
        // int a=5;
        //int b=5;
        //  int c=10;
        int [] a= {2,4,5,6};
        ;
        int[] answer; //4# get return value

        answer = numbers(a);//1#passing data
        System.out.println(Arrays.toString(answer));

    }
}
