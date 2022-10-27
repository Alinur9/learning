package virtual.contest;

public class XOROperationInAnArr {

    public int xorOperation(int n, int start) {
        int xor_arr = 0;
        int[] nums = new int[n];
        for (int i=0; i < n;i++){
            nums[i] = start+2*i;

            xor_arr = xor_arr ^ nums[i];
        }

        return xor_arr;


    }

    public static void main(String[] args) {

        int n = 4;
        int start = 3;

        XOROperationInAnArr obj = new XOROperationInAnArr();
        System.out.println(obj.xorOperation(n,start));

    }
}
