
import java.util.Arrays;
public class FindDnums {
    public int findDuplicates(int[] nums){
        Arrays.sort(nums);
        for(int i=1 ;i < nums.length;i++) {

            if (nums[i] == nums[i - 1])
                return nums[i];
        }
        return -1;
    }
    public static void main(String[] args){
        int[] nums ={1,1,2};

        int pass;
        FindDnums c = new FindDnums();
        pass= c.findDuplicates(nums);
            System.out.println(pass);
        }
    }
