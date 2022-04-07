public class MaximunDif {
    public int maximumDifference(int[] nums) {
        int max=-1;
        for(int i=0;i<nums.length-1;i++) {
            for(int j=i+1;j<nums.length;j++) {
                if(nums[j]-nums[i]>max && nums[j]-nums[i]>0)
                    max=nums[j]-nums[i];
            }
        }
        return max;
    }
    public static void main (String[] args ){
        int [] nums = {9,4,3,2};
        int result;
        MaximunDif c = new MaximunDif();
        result =c.maximumDifference(nums);
        System.out.println(" " + result);
    }
}
