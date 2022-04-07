import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class ArrayIntersection {
    public int[] intersectionOfArray(int[] nums1 , int[] nums2 ){
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> res = new ArrayList<>();
        //Add all elements to set from array 1

        for(int i =0; i< nums1.length; i++)
            set.add(nums1[i]);
        for(int j = 0; j < nums2.length; j++) {
            // If present in array 2 then add to res and remove from set
            if(set.contains(nums2[j])) {
                res.add(nums2[j]);
             set.remove(nums2[j]);
            }
        }
        // Convert ArrayList to array
        int[] arr = new int[res.size()];
        for (int i= 0; i < res.size(); i++) arr[i] = res.get(i);
        return arr;
    }
    public static void main (String[] args){
        int [] nums1 ={4,4,6};
        int [] nums2 ={9,4,8,9,4};
        ArrayIntersection c = new ArrayIntersection();
        int[] len=c.intersectionOfArray(nums1,nums2);
        System.out.println(Arrays.toString(len));
    }
}
