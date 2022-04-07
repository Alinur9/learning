public class SearchInsE {
     public int insertE(int[] nums, int target){
        for (int i=0 ; i < nums.length; i++)
            if( nums[i] == target)
            return  i ;

        else if ( nums[i] > target)
            return  i ;

        return nums.length;
    }
    public static void main (String[] args ){
        int [] nums= {1,3,4,5};
        int target =1;
       SearchInsE c = new SearchInsE();
       c.insertE(nums,target);
        System.out.println(c.insertE(nums,target));
    }
}
