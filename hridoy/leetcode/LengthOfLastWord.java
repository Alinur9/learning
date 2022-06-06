package leetcode.com.company;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        String[] ans = s.split(" ");
       int res = ans[ans.length-1].length();


       return res;

    }

    public static void main(String[] args) {
        String s = "luffy is still joyboy";
        LengthOfLastWord obj = new LengthOfLastWord();
        System.out.println(obj.lengthOfLastWord(s));

    }
}
