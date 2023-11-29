package com.hridoy;

public class ShortestDisTrgtStrInCrcArr {
    public int closetTarget(String[] words, String target, int startIndex) {
        if (words[startIndex].equals(target)){
            return 0;
        }
        if(startIndex+1 != words.length && words[startIndex+1].equals(target)){
            return 1;
        }
        int idx = startIndex;
        int n = words.length;
        int shortestDis=100;
        int forward =0;
        int backward = 0;
        int i =0;
        while (n!=0){
            i++;
            forward++;
            if(i == words.length-1 || idx+i == words.length-1 ||idx == words.length-1){
                i =0;
                idx= 0;
                forward++;
            }
            if ( words[idx+i].equals(target)){
                shortestDis = forward;
                break;
            }
            n--;
        }

        n = words.length;
        int j = startIndex;
        while (n!=0){
            j--;
            if(j<0){
                j = words.length-1;
            }
            backward++;
            if(words[j].equals(target)){
                if(shortestDis==100){
                    shortestDis = backward;
                    break;
                }  if (backward<shortestDis) {
                    shortestDis = backward;
                    break;
                }
            }
           n--;
        }
        if (shortestDis == 100){
            return -1;
        }

        return shortestDis;
    }

    public static void main(String[] args) {
        String[] words = {"ixgfxcpcbc","noltxvwjfu","uxtsrnulju","noltxvwjfu","hsojlwnjew","mmppqxgzub","hesbexhwxo","ybjeptueck","hsojlwnjew","iuqgsokpbk"};




        String target = "ybjeptueck";
        int startIndex =9;
        ShortestDisTrgtStrInCrcArr obj = new ShortestDisTrgtStrInCrcArr();
        System.out.println(obj.closetTarget(words,target,startIndex));

    }
}
