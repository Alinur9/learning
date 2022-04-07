import java.util.Arrays;

public class test3 {
    public int removeDupl(int[] nums) {
        int j = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                nums[j] = nums[i + 1];
                j++;
            }
        }
        return j;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 3};
        //int len;
        test3 c = new test3();
        c.removeDupl(nums);
       // for (int i = 0; i < len; i++) {
            System.out.println(Arrays.toString(nums));
        }

    }

