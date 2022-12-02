import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class MostPopVdo {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        //for 1st creator
        ArrayList<String> list1 = new ArrayList<>();
        //for second creator
        ArrayList<String> list2 = new ArrayList<>();
        //map for creator views
        HashMap<String,Integer> mapForViews = new HashMap<>();
        //map for creator ids
        HashMap<String,String> mapForIds = new HashMap<>();
        //final ans
        List<List<String>> ans = new ArrayList<>();
         int n = creators.length;

         int sum =0;
         //track view
        int track = 0;

        //checkCreator for sum of views
        ArrayList<String> checkCreator = new ArrayList<>();


        for (int i =0 ; i < n ;i++ ){
        if (!mapForViews.containsKey(creators[i])) {
            mapForViews.put(creators[i], views[i]);
            mapForIds.put(creators[i], ids[i]);
        }
        for (int j = i+1 ; j < n ;j++) {
            if (mapForViews.containsKey(creators[j]) && creators[j].equals(creators[i])){
                //sum for multi creators views
                if (!checkCreator.contains(creators[i])) {
                    sum += mapForViews.get(creators[i]) + views[j];
                    mapForViews.put(creators[j], sum);
                    sum = 0;
                }
                //find the lexicographically smallest id by track views
              if(views[j] > views[i] ){
                   mapForIds.put(creators[j],ids[j] );
                   track = views[j];
                }
              if (views[j] == views[i] && views[j] >= track){
                  if (mapForIds.get(creators[j]).compareTo(ids[j]) >= 0 && ids[i].compareTo(ids[j]) >= 0){
                      mapForIds.put(creators[j],ids[j] );
                  }
                  if (mapForIds.get(creators[j]).compareTo(ids[i]) >= 0 && ids[j].compareTo(ids[i]) >= 0){
                      mapForIds.put(creators[j],ids[i] );
                  }
              }
            }
        }
        checkCreator.add(creators[i]);

    }
        // 1st  creator
        String key = "";
        int max =0;
    for (int i =0; i < n;i++){

        if (mapForViews.containsKey(creators[i])){
            if (mapForViews.get(creators[i]) > max){
                max = mapForViews.get(creators[i]);
                key = creators[i];
            }
        }
    }
    max=0;
        list1.add(key);
        list1.add(mapForIds.get(key));
        ans.add(list1);
        //2nd creator if available
String key2 ="";
        for (int i =0; i < n;i++){
            if (mapForViews.containsKey(creators[i]) && !Objects.equals(creators[i], key)){
                if (mapForViews.get(creators[i]) > max){
                    max = mapForViews.get(creators[i]);
                    key2 = creators[i];
                }
            }
        }
//2nd creator if available
    if (!key2.equals(key) && !key2.isEmpty()){
        list2.add(key2);
        list2.add(mapForIds.get(key2));
        ans.add(list2);
    }
    return ans;
    }
    public static void main(String[] args) {
        String[] creators ={"alice","alice","alice"};
        String[] ids = {"a","b","c"};
        int[] views ={1,2,2};
        MostPopVdo obj = new MostPopVdo();
        System.out.println(obj.mostPopularCreator(creators,ids,views));
    }
}
