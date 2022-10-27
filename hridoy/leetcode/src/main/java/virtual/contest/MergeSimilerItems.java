package virtual.contest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MergeSimilerItems {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<List<Integer>> elements = new ArrayList<>();

        for (int i = 0; i < items1.length; i++) {
            map.put(items1[i][0], items1[i][1]);
        }
        for (int j = 0; j < items2.length; j++) {
            if (map.containsKey(items2[j][0])) {
                int totalWeight = map.get(items2[j][0]) + items2[j][1];
                map.put(items2[j][0], totalWeight);
            }
          if (!map.containsKey(items2[j][0])) {
              map.put(items2[j][0], items2[j][1]);
          }
        }
            List<Integer> weightByKey = new ArrayList<>(map.keySet());
            Collections.sort(weightByKey);
            for (int key : weightByKey){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(key);
                list.add(map.get(key));
                elements.add(list);
                }
        return elements;
    }
    public static void main(String[] args) {

        int[][] items1 = {{1,1},{4,5},{3,8}};
        int[][] items2 = {{3,1},{1,5}};
        MergeSimilerItems obj = new MergeSimilerItems();
        System.out.println(obj.mergeSimilarItems(items1,items2));

    }
}
