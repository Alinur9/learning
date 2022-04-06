package leetcode.com.company;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> allPossibleTimes = new ArrayList();

        for(int hour=0;hour<12;hour++){
            for(int minute=0;minute<60;minute++){
                if(Integer.bitCount(hour)+Integer.bitCount(minute) == turnedOn){
                    StringBuilder time = new StringBuilder();
                    time.append(hour).append(":");
                    if(minute<10){
                        time.append("0");
                    }
                    time.append(minute);
                    allPossibleTimes.add(time.toString());
                }
            }
        }
        return allPossibleTimes;

    }

    public static void main(String[] args) {
        int turnedOn = 1;
        BinaryWatch obj = new BinaryWatch();
        obj.readBinaryWatch(turnedOn);
        System.out.println(obj.readBinaryWatch(turnedOn));
        System.out.println(Integer.bitCount(32));

    }
    }
