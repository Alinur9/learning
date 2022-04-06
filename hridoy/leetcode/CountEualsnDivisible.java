package leetcode.com.company;

public class CountEualsnDivisible {
    public int countPairs(int[] nums, int k) {
        int r = 0;
        int count=0;
            for(int i = 0; i < nums.length-1;i++){
                for (int j = i+1; j < nums.length;j++){
                    if (nums[i] == nums[j]){
                        r = i * j;
                        if( r % k == 0){
                            count++;
                        }

                    }
                }
            }
            return count;
        }



    public static void main(String[] args) {
        int[] nums ={3,1,2,2,2,1,3};
        int k = 2;
        int res;
        CountEualsnDivisible obj = new CountEualsnDivisible();
        res=obj.countPairs(nums,k);
        System.out.println(res);
    }
}
