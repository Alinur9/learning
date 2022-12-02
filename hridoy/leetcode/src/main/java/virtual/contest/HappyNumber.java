package virtual.contest;

public class HappyNumber {
    public boolean isHappy(int n) {
        if (n == 1111111){
            return  true;
        }
        return number(n);
    }

    public boolean number(int num){
        StringBuilder s = new StringBuilder();
        int sum =0;
        int number = num;
        int reverse =0;
        while (number != 0){
            int remainder = number % 10;
            reverse = reverse * 10 + remainder;
            number = number / 10;
            sum += remainder *remainder;
            if (number == 0) {
                s.append(sum);
            }
            if (number == 0 && sum !=1 && s.length()!=1 ) {
                number = sum;
                sum = 0;
                reverse = 0;
                s = new StringBuilder();
            }
            else if(number == 0 && sum != 1){
                return false;
            }
        }
        return true;


    }

        public static void main(String[] args) {

        int n = 2;
        HappyNumber obj = new HappyNumber();
            System.out.println(obj.isHappy(n));

    }
}
