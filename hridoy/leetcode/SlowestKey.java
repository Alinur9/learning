package leetcode.com.company;

public class SlowestKey {
    public char slowestKey(int[] releaseTimes, String keysPressed) {

        int max = releaseTimes[0];
        char maxKey = keysPressed.charAt(0);
        int n = releaseTimes.length;
        for (int i = 1; i < n; i++) {
            int diff = releaseTimes[i] - releaseTimes[i-1];
            if (diff > max ){
                max = diff;
                maxKey = keysPressed.charAt(i);
            }else  if (diff == max ){
                maxKey = (char)Math.max(maxKey,keysPressed.charAt(i));
            }
        }
        return maxKey;

    }
    public static void main(String[] args) {

        int[] nums = {2,4,10,16,25,26,28,33,75,81};
        String s = "duxwdgmgw";
        SlowestKey obj = new SlowestKey();
        System.out.println(obj.slowestKey(nums,s));

    }
}
