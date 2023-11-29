package virtual.contest;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RingsAndRods {
    public int countPoints(String rings) {
        char red = 'R';
        int pointRed =0;
        char blue = 'B';
        int pointBlue =0;
        int pointGreen =0;
        int count =0;

        HashMap<Integer,String> map = new HashMap<>();
        for(int i =0 ;i < rings.length()-1;i+=2){
            int rod = Integer.parseInt(String.valueOf(rings.charAt(i+1)));
            if(map.containsKey(rod)){
                map.put(rod,map.get(rod)+rings.charAt(i));
                continue;
            }
            map.put(rod, String.valueOf(rings.charAt(i)));
        }
        for(int i=0; i < 10;i++){
            if (map.containsKey(i)){
                String s = map.get(i);
                for (int j =0 ;j < s.length();j++){
                    if (s.charAt(j) == red){
                        pointRed =1;
                    }else if(s.charAt(j) == blue){
                        pointBlue = 1;
                    }else {
                        pointGreen =1;
                    }
                }
                if (pointBlue != 0 && pointRed !=0 && pointGreen!= 0){
                    count++;
                }
                pointBlue =0;
                pointRed =0;
                pointGreen =0;

            }
        }

        return count;

    }
    public static void main(String[] args) {

        String rings = "G4";
        RingsAndRods obj = new RingsAndRods();
        System.out.println(obj.countPoints(rings));

    }
}
