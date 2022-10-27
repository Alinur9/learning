package virtual.contest;

public class FineEvenOFDigits {
    public int findNumbers(int[] nums) {
        int even =0;
        for (int i =0; i < nums.length;i++){
            String s = String.valueOf(nums[i]);
            if (s.length() %2 == 0){
                even++;
            }
        }
return even;
    }


    public static void main(String[] args) {

        int[] nums = {12,345,2,6,7896};
        FineEvenOFDigits obj = new FineEvenOFDigits();
        System.out.println(obj.findNumbers(nums));

    }
}
