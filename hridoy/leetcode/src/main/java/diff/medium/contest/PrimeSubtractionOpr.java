package diff.medium.contest;

public class PrimeSubtractionOpr {

    public boolean primeSubOperation(int[] nums) {
        int prev = nums[0];
        int temp =0;

        for (int i=1;i< nums.length;i++){
            boolean found = true;
            if(prev > nums[i]) {
                found = false;
            }
            for (int j = 2; j < nums[i]; j++) {

                if (isPrime(j) ) {
                    if(temp < j){
                        temp = j;
                    }
                }

            }
            nums[i] -= temp;
            if(nums[i] > prev) {
                found = true;
            }
            if (!found) {
                return false;
            }
            prev =nums[i];
            temp=0;
        }
        return true;
}
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int[] nums = {998,2};
        PrimeSubtractionOpr obj = new PrimeSubtractionOpr();
        System.out.println(obj.primeSubOperation(nums));
    }
}
