package leetcode.com.company;

import java.util.ArrayList;
import java.util.List;

public class PasclsTriangleByIndex {

    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> head = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        head.add(list);
        for(int i = 1 ; i <= rowIndex; i++){
            List<Integer> list2 = new ArrayList<>();
            list2.add(1);
            for(int j = 1; j<i ;j++){
                int sum = head.get(i-1).get(j-1) + head.get(i-1).get(j);
                list2.add(sum);
            }
          list2.add(1);
            head.add(list2);
        }
        return head.get(rowIndex);
    }

    public static void main(String[] args) {
        int indx = 3;
        PasclsTriangleByIndex obj = new PasclsTriangleByIndex();
        System.out.println(obj.getRow(indx));

    }
}
