
import java.util.HashSet;
import java.util.Set;

public class VowelReverse{
    public String reversing(String s ){
        if ( s == null || s.length() < 1 ) return  s;
        char [] charArr = s.toCharArray();
        int start = 0;
        int end = s.length()-1;
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        while ( start < end){
            if (!vowels.contains(charArr[start])) start++;
            else if (! vowels.contains(charArr[end])) end--;
            else{
                char temp = charArr[start];
                charArr[start] = charArr[end];
                charArr[end] = temp;
                start ++;
                end --;
            }
        }
        return  String.valueOf(charArr);
    }


    public static void main (String[] args){
        String word = "AA";
        VowelReverse c = new VowelReverse();
        c.reversing(word);
        System.out.println(c.reversing(word));
    }
}

