package leetcode.com.company;

public class SubStringOfSize {
    public int countGoodSubstrings(String s) {
        int count = 0;

        for (int i =0 ; i < s.length()-2; i ++){

          String  checkIsGood =  s.substring(i,i+3);
              char ch = checkIsGood.charAt(0);
              char ch1= checkIsGood.charAt(1);
              char ch2 = checkIsGood.charAt(2);

              if (checkIsGood.indexOf(ch ) == checkIsGood.lastIndexOf(ch) && checkIsGood.indexOf(ch1 ) == checkIsGood.lastIndexOf(ch1) && checkIsGood.indexOf(ch2) == checkIsGood.lastIndexOf(ch2) ){
                  count ++;
              }
          }

        return count;
        }



    public static void main(String[] args) {
        String s = "xyzzaz";
        SubStringOfSize obj = new SubStringOfSize();
        System.out.println(obj.countGoodSubstrings(s));
    }
}
