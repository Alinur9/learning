package virtual.contest;

public class MaximumNumberOfWordsFoundInSentences {
    public int mostWordsFound(String[] sentences) {
        String s;
        int countSpaces =0;
        int max = 0;
        for (int i =0; i < sentences.length; i++){
            s = sentences[i];
            for (char c : s.toCharArray()){
                if (c == ' '){
                    countSpaces++;
                }
            }
            if (countSpaces >= max){
                max = countSpaces;
                max++;
            }
            countSpaces =0;
        }
    return max;
    }

    public static void main(String[] args) {

        String[] sentences = {"alice and bob love leetcode","i think so too","this is great thanks very much"};
        MaximumNumberOfWordsFoundInSentences obj = new MaximumNumberOfWordsFoundInSentences();
        System.out.println(obj.mostWordsFound(sentences));
    }
}
