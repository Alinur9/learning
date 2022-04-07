import java.util.ArrayList;

public class VowelChar {
    ArrayList<Character>ch;
     VowelChar(){
        ch = new ArrayList<>();
        ch.add('a');ch.add('A');
        ch.add('e');ch.add('E');
        ch.add('i');ch.add('I');
        ch.add('o');ch.add('O');
        ch.add('u');ch.add('U');
        }
        private boolean isVowel(char c)
        {
         for ( int in = 0 ; in < ch.size();in++)
         {
             if ( c == ch.get(in)){
                 return  true;
             }
         }
         return false;

    }
    public int vowelsCount(String s){
         int vowelCount = 0;
         int  leng = s.length();
         for ( int out = 0 ; out< leng; out++){
             char c = s.charAt(out);
             if (isVowel(c)){
                 vowelCount++;
             }
         }

         return  vowelCount;
    }

    public static void main(String[] args) {
        String word = "i love to learn";
        VowelChar c = new VowelChar();
        int vowelCount=c.vowelsCount(word);
        System.out.println("String :" + word);
        System.out.println("total vowel count number is : " + vowelCount);

    }
}