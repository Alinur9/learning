

public class RemoveOcc {
    public int removeEle(int[] nums,int val){
     int j = 0 ;
     for (int i =0 ; i < nums.length; i++) {
         if (nums[i] != val) {
             nums[j] = nums[i];
             j++;
         }
     }


        return j;
    }
    public static void main (String[] args ){
        int [] nums = {2,2,3,3};
       // int leng=0;
        int val = 3;
       int leng = nums.length;
       RemoveOcc c = new RemoveOcc();
       leng=c.removeEle(nums,val);
       for ( int i = 0 ; i < leng; i++){
           System.out.print(" " + nums[i]);
       }

    }
}
