package diff.medium.contest;

import java.util.ArrayList;
import java.util.List;

public class SentenceSimilarity {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        ArrayList<String> list1 = new ArrayList<>();
        String s = "";
        for (int i =0 ; i < sentence1.length();i++){

            if (sentence1.charAt(i) == ' '){
                list1.add(s);
                s = "";
            }
            s += sentence1.charAt(i);
            if (i == sentence1.length()-1){
                list1.add(s);
            }
        }
        List<String> list2 = new ArrayList<>();
        String s1 = "";
        for (int j =0; j < sentence2.length();j++){

            if (sentence2.charAt(j) == ' '){
                list2.add(s1);
                s1 = "";
            }
            s1 += sentence2.charAt(j);
            if (j == sentence2.length()-1){
                list2.add(s1);
            }

        }
        StringBuilder result = new StringBuilder();
        for (int k =0; k < list1.size();k++){
            if (k >= list2.size()){
                result.append(list1.get(k));
            }
            if (k < list2.size() && !list1.get(k).equals(list2.get(k))){
                result.append(list1.get(k));
            }if (k < list2.size() && list1.get(k).equals(list2.get(k))) {
                result.append(list1.get(k));
            }

        }
        result.setLength(result.length());
        String ans = result.toString();
        if (ans.equals(sentence1)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        String sentence1 = "My name is Haley";
        String sentence2 = "My Haley";
        SentenceSimilarity obj = new SentenceSimilarity();
        System.out.println(obj.areSentencesSimilar(sentence1,sentence2));


    }
}
