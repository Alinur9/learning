package leetcode.com.company;

public class BinaryGap {
    public int binaryGap(int n){

        String s = Integer.toBinaryString(n);
        int currD=0, maxD=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                maxD = Math.max(maxD, currD);
                currD = 1;
            }else if(s.charAt(i)=='0' && currD>0){
                currD++;
            }
        }
        return maxD;
    }

    public static void main(String[] args) {
        int n = 1010;
        BinaryGap obj = new BinaryGap();
        int res = obj.binaryGap(n);
        System.out.println(res);
    }
}
