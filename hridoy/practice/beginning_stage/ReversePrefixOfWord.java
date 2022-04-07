public class ReversePrefixOfWord {
    public String prefixOfWord(String word, char ch){
        int i=0;
        int length = word.length();

        while( i < length && word.charAt(i) != ch) {
            i++;
        }
            if ( i == length) {
                return word;
            }

                StringBuilder sb = new StringBuilder(word.substring(0, i + 1));
                String firstPart = sb.reverse().toString();
                String secondPart = word.substring(i + 1);
                return (firstPart + secondPart);
    }
    public static void main (String[] args){
        String word = "abcdefd";//xyxzxe , abcd
        char ch = 'd';// x , z
        ReversePrefixOfWord c = new ReversePrefixOfWord();
        c.prefixOfWord(word,ch);
        System.out.println(c.prefixOfWord(word,ch));
    }
}
