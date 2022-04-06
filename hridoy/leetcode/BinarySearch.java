package leetcode.com.company;

public class BinarySearch {
    public int search(int[] nums, int target) {
        int size = nums.length-1;
        for (int i =0; i <= size ; i++){
            if (nums[i] == target){
                return i;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        int[] nums = {5,2,4};
        int target = 4;
        BinarySearch obj = new BinarySearch();
       int res = obj.search(nums,target);
        System.out.println(res);
    }

}
