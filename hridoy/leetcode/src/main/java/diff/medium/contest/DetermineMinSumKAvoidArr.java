package diff.medium.contest;

import java.util.ArrayList;
import java.util.List;

public class DetermineMinSumKAvoidArr {
    public int minimumSum(int n, int k) {
        int sum=0;
        List<Integer> nums = new ArrayList<>();

        for(int i=0;i<= n;i++){
            nums.add(i+1);
        }
        for(int i =0;i<nums.size();i++){
            if(nums.get(i) == 0){
                continue;
            }
            for(int j= i+1;j<nums.size();j++){
                if(nums.get(i) + nums.get(j) == k){
                    nums.set(j,0);
                }
            }
          sum += nums.get(i);
        }
    return sum;
    }
    public static void main(String[] args) {
        int n = 2;
        int k =6;
        DetermineMinSumKAvoidArr obj = new DetermineMinSumKAvoidArr();
        System.out.println(obj.minimumSum(n,k));
    }
}
