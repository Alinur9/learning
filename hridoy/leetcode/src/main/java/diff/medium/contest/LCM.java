package diff.medium.contest;

public class LCM {
    public int subarrayLCM(int[] nums, int k) {
     int count = 0;
     int n = nums.length;
     int [] arr = new int[n];

     for (int i =0 ; i < n;i++) {
         if (k % nums[i] == 0){
             arr[i] = k / nums[i];
         }
     }
         for (int j = 0; j < n; j++) {
             boolean flag = false;
             for (int k1 = j; k1 < n; k1++) {
            if (arr [k1] == 0) break;
            if (arr[k1] == 1){
                flag = true;
            }
            if(flag){
                count++;
            }
             }
         }
return count;
    }
    public static void main(String[] args) {
        int [] nums = {3,6,2,7,1};
        int k =6;
        LCM obj = new LCM();
        System.out.println(obj.subarrayLCM(nums,k));

    }
}
