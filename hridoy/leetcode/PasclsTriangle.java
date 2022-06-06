package leetcode.com.company;

import java.util.ArrayList;
import java.util.List;

public class PasclsTriangle {
    List<List<Integer>> headList = new ArrayList<>();
    public List<List<Integer>> generate(int numRows) {

        if (numRows ==1 ){
            List<Integer> list1 = new ArrayList<>();
            list1.add(1);
            headList.add(list1);
            return headList;
        }
        if (numRows ==2 ){
            List<Integer> list1 = new ArrayList<>();
            list1.add(1);
            List<Integer> list2 = new ArrayList<>();
            list2.add(1);
            list2.add(1);
            headList.add(list1);
            headList.add(list2);
            return headList;
        }

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(1);
        headList.add(list1);
        headList.add(list2);

        for(int i =2; i < numRows;i++){
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for (int j =1 ; j<= i;j++){
                if(j!=i){
                    int temp = headList.get(i-1).get(j-1)+headList.get(i-1).get(j);
                    list.add(temp);
                }
                else list.add(1);
            }
            headList.add(list);
        }
        return headList;
    }

      public List<Integer> getRow(int rowIndex) {
        return headList.get(rowIndex);
      }

    public static void main(String[] args) {

        int numRows = 5;
        PasclsTriangle obj = new PasclsTriangle();
        System.out.println(obj.generate(numRows));

        System.out.println(obj.getRow(3));


    }
}
