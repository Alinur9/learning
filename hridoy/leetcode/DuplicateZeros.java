package leetcode.com.company;
import java.util.ArrayList;
import java.util.Arrays;
public class DuplicateZeros {
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> list = new ArrayList<>(arr.length);

        for (int i =0; i < n; i++){
            if (arr[i] == 0){
                if (list.size() == arr.length){
                    break;
                }
                list.add(0);
            }
            if (list.size() == arr.length){
                break;
            }
            list.add(arr[i]);
            }
        for (int j =0 ; j < list.size();j++){
            arr[j] = list.get(j);
        }
        System.out.println(Arrays.toString(arr));
        }
    public static void main(String[] args) {
        int [] arr = {0,1,7,6,0,2,0,7};
        DuplicateZeros obj = new DuplicateZeros();
        obj.duplicateZeros(arr);
    }
}
