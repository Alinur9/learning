import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


public class CommonCharacters {
    public List<String> findCommonChar(String[] word) {
        List<String> res = new ArrayList<>();
        HashSet<Character> set = new HashSet<>();
        int k = 0;
        int j = 0;
        for (int i = 0; i < word.length; i++) {
            if (i == 1) break;

            for (j = 0; j < word[i].length(); j++) {
                set.add(word[i].charAt(j));

                for (k = 0; k < word[i + 2].length(); k++) {
                    if (set.contains(word[i + 2].charAt(k))) {
                        res.add(String.valueOf(word[i + 2].charAt(k)));
                        set.remove(word[i + 2].charAt(k));
                    }
                }
            }
        }
        return res;
    }
    public static void main ( String [] args ){
        String[] words = { "bella", "ell","roller"};
        CommonCharacters c = new CommonCharacters() ;
        c.findCommonChar(words);
        System.out.println(c.findCommonChar(words));
    }
}
