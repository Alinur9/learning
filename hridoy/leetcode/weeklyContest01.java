package leetcode.com.company;

public class weeklyContest01 {

    public int divisorSubstrings(int num ,int k) {
        int count = 0;

        String s = String.valueOf(num);

        for (int i =0 ; i <= s.length()-k ; i++) {

                String s1 = s.substring(i,i+k);
                int j = Integer.parseInt(s1);

                if (j != 0 && num % j == 0) {
                    count++;
                }
            }
        return count;
    }

    public static void main(String[] args) {

        int num = 430043 ;
        int k = 2;
        weeklyContest01 obj = new weeklyContest01();
        System.out.println(obj.divisorSubstrings(num,k));
    }
}
