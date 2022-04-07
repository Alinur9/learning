import java.util.Arrays;

class twosum {
    public int[] sum(int[] num, int target) {
        for (int i = 0; i < num.length - 1; i++)
            for (int j = i + 1; j < num.length; j++)
                if (num[0] + num[1] == target)
               return new int[]{i,j};
              //  else {
               return new int[]{num[0],num[1]};
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 9};
        int tar = 9;
       // int n = nums.length;
        int[] result;
        twosum k = new twosum();
         result=k.sum(nums,tar);
        System.out.println(Arrays.toString(result));

                   // System.out.println(result);

                }
            }


