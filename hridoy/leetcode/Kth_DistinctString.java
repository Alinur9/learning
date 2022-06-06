package leetcode.com.company;

public class Kth_DistinctString {

    public String kthDistinct(String[] arr, int k) {
        int count;
        int count1 = 0;
        int i =0;
String s ="";
        while ( i < arr.length) {

            count =0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i].equals(arr[j])) {
                    count++;
                    if(count > 1){
                        break;
                    }
                }
            }
            if (count == 1) {
                // item is  distinct
                count1++;
            }
            if (count1 == k) {
                s = arr[i];
                return s;
            }
            i++;
        }
        return s;
        }






    public static void main(String[] args) {
        String[] arr = {"d","b","c","b","c","a"
        };

        int k =2;

        Kth_DistinctString obj = new Kth_DistinctString();
        System.out.println(obj.kthDistinct(arr,k));

    }
}
