import java.util.Arrays;

public class MoveZeros {
    public void moveZerosnum(int [] nums){

            int pointer = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {

                    nums[pointer] = nums[i];

                    if (pointer != i)

                        nums[i] = 0;
                        pointer++;

                }
            }
        }
    public static void main (String[] args){
        int [] passNums={2,1};
        MoveZeros c = new MoveZeros();
        c.moveZerosnum(passNums);
        System.out.println( Arrays.toString(passNums));
    }
}
