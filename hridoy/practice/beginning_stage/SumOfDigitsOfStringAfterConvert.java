

public class SumOfDigitsOfStringAfterConvert {
    public int sumAfterConvert(String s , int times){
        int sum = 0;
        for(int i=0;i<s.length();i++) {
            int map = s.charAt(i) - 'a' + 1;
            sum += map % 10 + map / 10;
        }
        for(int i=1;i<times;i++) {
           int nextSum = 0;

            while(sum>0) {
                nextSum += sum % 10;
                sum /= 10;
            }
         sum   = nextSum ;
        }
        return sum;
    }
    public static void main (String[] args){
        String words = "leetcode";
        int k = 2;
        SumOfDigitsOfStringAfterConvert c = new SumOfDigitsOfStringAfterConvert();
        k = c.sumAfterConvert(words,k);
        System.out.println(""+k);
    }
}
