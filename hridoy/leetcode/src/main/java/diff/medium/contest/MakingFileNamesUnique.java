package diff.medium.contest;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class MakingFileNamesUnique {
    public String[] getFolderNames(String[] names) {
        HashMap<String,Integer> map = new HashMap<>();
        for (int i =0; i < names.length;i++){
            String current = names[i];
                while (map.containsKey(current)){
                    int k = map.get(names[i]);
                    k += 1;
                    map.put(names[i], k);
                    StringBuilder sb = new StringBuilder();
                    sb.append(names[i]);
                    sb.append("(");
                    sb.append(k);
                    sb.append(")");
                    current = sb.toString();
                }
                map.put(current,0);
                names[i] = current;
                }
        return names;
    }
    public static void main(String[] args) {
        String[] names = {"wano","wano(1)","wano(2)","wano"};

        MakingFileNamesUnique obj = new MakingFileNamesUnique();
        System.out.println(Arrays.toString(obj.getFolderNames(names)));
    }
}
