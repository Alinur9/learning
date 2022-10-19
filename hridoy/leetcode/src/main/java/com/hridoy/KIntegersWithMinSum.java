
import java.util.Arrays;

public class KIntegersWithMinSum {
    public long minimalKSum(int[] nums, int k) {
  Arrays.sort(nums);
  long res = 0;
  for (int i =0;i < nums.length && k >= nums[i]; i++){
      if (i == 0 || nums[i] != nums[i-1]){
          res -= nums[i];
          k++;
      }
  }
  return res + (long)k * (k+1) /2;
    }




    public static void main(String[] args) {
int [] nums ={1,4,25,10,25};
int k = 2;
long res;

KIntegersWithMinSum obj = new KIntegersWithMinSum();

res = obj.minimalKSum(nums,k);

        System.out.println(res);

    }
}
