import java.util.Arrays;

public class MinNmax {
    public int differenceMinMax(int[] nums, int k){
        if (k==1) return 0;
        int i = 0 ;
        int j = k-1;
        int result=Integer.MAX_VALUE;

        Arrays.sort(nums);
        while ( j < nums.length){
            result = Math.min(result,nums[j]-nums[i]);
            j++;
            i++;
        }
return result;



    }
    public static  void main(String[] args){
        int[] a = {9,4,1,7};
        int k = 2;
        int val;
        MinNmax c = new MinNmax();
        val=c.differenceMinMax(a,k);
        System.out.println(" "+val);
    }
}
