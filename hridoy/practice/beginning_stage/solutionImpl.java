
class RemoveDup {
    public static int removeDuplicates(int[] nums) {
            int j = 1;
            for(int i = 0; i < nums.length-1; i++) {
                if(nums[i]<nums[i+1]) {
                    nums[j] = nums[i+1];
                    j++;
                }
            }
            return j;
    }
    public static void main(String[] args)
    {
        int[] nums= {1,1,1,2,3,5,3};
       // int n= nums.length;
        int pass;
        pass=removeDuplicates(nums);
        for(int i=0;i<pass;i++)
        {
            System.out.print(" "+ nums[i]);
        }
    }
}