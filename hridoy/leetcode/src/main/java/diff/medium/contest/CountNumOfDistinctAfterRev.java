package diff.medium.contest;

public class CountNumOfDistinctAfterRev {
    public int countDistinctIntegers(int[] nums) {

        String a = "";
        String b ="";
        int count =1;
        int number =0;
        int reverse2 = 0;
        int track = -1;
boolean access2= true;

        for (int i =0 ; i < nums.length;i++){
            int remainder =0;
            int reverse = 0;

            boolean access = true;
            number = nums[i];
            while (number!= 0) {
                 remainder = number % 10;
                reverse = reverse*10+remainder;
                number=number/10;
                a += String.valueOf(reverse);
            }
            remainder =0;
            for (int j = i+1; j < nums.length;j++){
                remainder =0;
                reverse2=0;
                number = nums[j];
                while (number!= 0){
                    remainder = number %10;
                    reverse2 = reverse2*10+remainder;
                    number=number/10;
                     b += String.valueOf(reverse2);
                }
                if( a.equals(b)){
                    access = false;
                    if (j == nums.length-1){
                        access2 = false;
                    }
                    break;
                }
                b="";
            }
            a ="";
            b="";
            if(access && access2){
                count++;

            }
        }
return count;
    }
    public static void main(String[] args) {
        int [] nums ={1,13,10,12,31};
        CountNumOfDistinctAfterRev obj = new CountNumOfDistinctAfterRev();
        System.out.println(obj.countDistinctIntegers(nums));
    }
}
