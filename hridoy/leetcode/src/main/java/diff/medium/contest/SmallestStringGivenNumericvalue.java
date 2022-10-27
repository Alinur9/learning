package diff.medium.contest;

public class SmallestStringGivenNumericvalue {
    public String getSmallestString(int n, int k) {

        String result = "";
        String resZZ = "";
        // 1 = 26 , 1 = 1
        int sum = k/25;
        while (k != 0 && n != 0){
            if (k <= 26 && n != 1){
                result += 'a';
                k--;
                n--;
                continue;
            }
            if (k <= 26 && n == 1){
                char c1 = (char) ('a' +k-1);
                result += c1;
                k-=k;
                n--;
                continue;
            }
            if (k -26 >= 26 && n >= sum){
                resZZ += 'z';
                k-= 25;
                n--;
                sum--;
                continue;
            }else {
                result += 'a';
                k--;
                n--;
            }
        }
        return result+resZZ;
    }

    public static void main(String[] args) {
        int n =5;
        int k = 73;

        SmallestStringGivenNumericvalue obj = new SmallestStringGivenNumericvalue();
        System.out.println(obj.getSmallestString(n,k));
    }
}
