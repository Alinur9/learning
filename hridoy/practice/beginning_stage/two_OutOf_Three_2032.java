import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class two_OutOf_Three_2032 {
    public static List<Integer> atLeastTwo(int[] nums1, int[] nums2, int[] nums3){
        List<Integer> list = new ArrayList<>();
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for ( int e  : nums1){
            set1.add(e);
            }
        for (int e2 : nums2){
            set2.add(e2);
            if (set1.contains(e2) && !list.contains(e2)){
                list.add(e2);
            }
            for(int e3 : nums3){
                if (set1.contains(e3) && !list.contains(e3) || set2.contains(e3) && !list.contains(e3)){
                    list.add(e3);
                }
                }
            }
        return list;


    }
    public static void main(String[] args) {
        int[] nums1 = {10,20,3,5,6,7}; //3,1
        int[] nums2 = {4,5,6,7,7,7}; //2,3
        int[] nums3 = {7,4,5,7,2,10}; // 3
       // two_OutOf_Three_2032 c = new two_OutOf_Three_2032();
       //List<Integer> sl =  c.atLeastTwo(nums1,nums2,nums3);
       System.out.println(atLeastTwo(nums1,nums2,nums3));//4,10,5,6,7




    }
}
