package leetcode.com.company;

public class BinaryAdd {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while(i >= 0 || j >= 0){
            int sum = carry;
            if(i >= 0) sum += a.charAt(i--) -'0' ;
            if(j >= 0) sum += b.charAt(j--) -'0';
            carry = sum > 1 ? 1 : 0;
            res.append(sum % 2);
        }
        if(carry != 0) res.append(carry);
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        BinaryAdd obj = new BinaryAdd();
         obj.addBinary(a,b);
         BinaryAdd res = new BinaryAdd();
        System.out.println(res.addBinary(a,b));
    }

}
