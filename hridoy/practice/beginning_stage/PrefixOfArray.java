

public class PrefixOfArray {
    public boolean  stringPrefixOfArray(String s, String[] words){
        int sPointer = 0 ;
        for (String word : words){
            if ( s.length()-sPointer  < word.length()){
                return false;
            }
            for (int i =0 ; i < word.length();i++){
                if (s.charAt(sPointer++) != word.charAt(i)){
                    return false;
                }
            }
            if (sPointer == s.length())
                return true;
        }
        return false;

        }




    public static void main (String[] args){
        String prefix = "ilovesalah";
        String[]  words= {"i","love","salah" ,"apples"};//apples
        PrefixOfArray c = new PrefixOfArray();
        c.stringPrefixOfArray(prefix,words);
        System.out.println(c.stringPrefixOfArray(prefix,words));
    }
}
