import java.util.Arrays;

public class oddeven {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 4, 6, 7, 8, -3, 11};
        int[] temp = new int[numbers.length];

        int j = numbers.length-1;
        int k = 0;

        for (int i = 0; i < numbers.length; i++)
            if (numbers[i] % 2 != 0)
                temp[j--] = numbers[i];
            else
                temp[k++] = numbers[i];

            copyArray(temp, numbers);
            System.out.println(Arrays.toString(numbers));

    }

        private static void copyArray ( int[] temp, int[] numbers){
            for (int i = 0; i < temp.length; i++)
                numbers[i] = temp[i];
        }
    }

