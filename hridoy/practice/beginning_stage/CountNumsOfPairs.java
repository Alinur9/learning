

public class CountNumsOfPairs {
    public int countnumbers(int [] nums,int k){
        int count = 0 ;
    for (int i = 0 ; i < nums.length;i++ ){
        for(int j =i+1; j < nums.length;j++){
            if (Math.abs(nums[j] - nums [i] ) == k) count ++;

        }
    }
return count;
    }
    public static void main (String[] args){
        int[] nums = {3,2,1,5,4} ; //
        int k = 2;
        CountNumsOfPairs c = new CountNumsOfPairs();
        c.countnumbers(nums,k);
        System.out.println(c.countnumbers(nums,k));
    }
}
