import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoArray {
    public int [] intersectionArr(int[] nums1, int[] nums2){
        Arrays.sort(nums1);
       Arrays.sort(nums2);
       int i = 0;
       int j = 0;
        List<Integer> list = new ArrayList<>();
        while ( i < nums1.length && j < nums2.length){
            if( nums1[i] < nums2[j]){
                i++;
            }
            else if (nums1[i] > nums2[j]){
                j++;
            }
            else {
                list.add(nums1[i]);
                i++;
                j++;
            }
            }
        int[] res = new int[list.size()];
        for (int k = 0; k < list.size();k++)
            res[k] = list.get(k);

        return res;



    }
    public static void main(String[] args){
        int[] nums1 = {1,2,2,1,4,3};
        int [] nums2 = {2,2,3};
        IntersectionOfTwoArray c = new IntersectionOfTwoArray();
        int[] len = c.intersectionArr(nums1,nums2);
        System.out.println(Arrays.toString(len));
    }
}
